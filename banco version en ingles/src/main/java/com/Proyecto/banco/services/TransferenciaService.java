package com.Proyecto.banco.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Proyecto.banco.dominio.enums.EstadoCuenta;
import com.Proyecto.banco.dominio.enums.EstadoTransferencia;
import com.Proyecto.banco.dominio.modelo.CuentaBancaria;
import com.Proyecto.banco.dominio.modelo.Transferencia;
import com.Proyecto.banco.dominio.puertos.jpa.CuentaRepository;
import com.Proyecto.banco.dominio.puertos.jpa.TransferenciaRepository;
import com.Proyecto.banco.bitacora.BitacoraService;

@Service
public class TransferenciaService {

    private final CuentaRepository cuentaRepository;

    private final TransferenciaRepository transferenciaRepository;

    private final AuditoriaService auditoriaService;

    private final BitacoraService bitacoraService;

    public TransferenciaService(

            CuentaRepository cuentaRepository,

            TransferenciaRepository transferenciaRepository,

            AuditoriaService auditoriaService,

            BitacoraService bitacoraService) {

        this.cuentaRepository = cuentaRepository;

        this.transferenciaRepository =
                transferenciaRepository;

        this.auditoriaService = auditoriaService;

        this.bitacoraService = bitacoraService;
    }
    @Transactional
    public Transferencia transferir(
            String numeroOrigen,
            String numeroDestino,
            BigDecimal monto) {

        CuentaBancaria origen = cuentaRepository.findById(numeroOrigen)
                .orElseThrow(() ->
                        new RuntimeException("Cuenta origen no encontrada"));

        CuentaBancaria destino = cuentaRepository.findById(numeroDestino)
                .orElseThrow(() ->
                        new RuntimeException("Cuenta destino no encontrada"));

        // VALIDAR CUENTAS ACTIVAS
        if (origen.getEstadoCuenta() != EstadoCuenta.ACTIVA) {
            throw new RuntimeException("La cuenta origen está bloqueada");
        }

        if (destino.getEstadoCuenta() != EstadoCuenta.ACTIVA) {
            throw new RuntimeException("La cuenta destino está bloqueada");
        }

        // VALIDAR MONTO
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Monto inválido");
        }

        // VALIDAR SALDO
        if (origen.getSaldoActual().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }

        // TRANSFERENCIA
        origen.retirar(monto);
        destino.depositar(monto);

        cuentaRepository.save(origen);
        cuentaRepository.save(destino);

        // REGISTRAR TRANSFERENCIA
        Transferencia transferencia = new Transferencia();

        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        transferencia.setMonto(monto);
        transferencia.setFechaCreacion(LocalDateTime.now());
        transferencia.setEstado(EstadoTransferencia.EJECUTADA);
        
        auditoriaService.registrar(

        origen.getTitular().getCorreo(),

        "TRANSFERENCIA",

        "Transferencia de "
                + monto
                + " desde "
                + numeroOrigen
                + " hacia "
                + numeroDestino);
        
        bitacoraService.registrar(

        "TRANSFERENCIA",

        origen.getTitular().getCorreo(),

        "CLIENTE",

        "CUENTA_BANCARIA",

        Map.of(

                "cuentaOrigen",
                numeroOrigen,

                "cuentaDestino",
                numeroDestino,

                "monto",
                monto));

return transferenciaRepository.save(transferencia);
    }
}