package com.Proyecto.banco.services;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.Proyecto.banco.dominio.enums.EstadoCuenta;
import com.Proyecto.banco.dominio.enums.EstadoPrestamo;
import com.Proyecto.banco.dominio.modelo.CuentaBancaria;
import com.Proyecto.banco.dominio.modelo.Prestamo;
import com.Proyecto.banco.dominio.puertos.jpa.CuentaRepository;
import com.Proyecto.banco.dominio.puertos.jpa.PrestamoRepository;
@Service
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final CuentaRepository cuentaRepository;
    private final AuditoriaService auditoriaService;
    public PrestamoService(
            PrestamoRepository prestamoRepository,
            CuentaRepository cuentaRepository,
            AuditoriaService auditoriaService) {
        this.prestamoRepository = prestamoRepository;
        this.cuentaRepository = cuentaRepository;
        this.auditoriaService = auditoriaService;
    }
    // CREAR SOLICITUD
    public Prestamo solicitarPrestamo(Prestamo prestamo) {
        prestamo.setEstado(EstadoPrestamo.EN_ESTUDIO);
        return prestamoRepository.save(prestamo);
    }
    // LISTAR TODOS
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
    // BUSCAR POR ID
    public Prestamo obtenerPrestamoPorId(Long id) {
        return prestamoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prestamo no encontrado"));
    }
    // APROBAR
    public Prestamo aprobarPrestamo(
            Long idPrestamo,
            BigDecimal montoAprobado) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() ->
                        new RuntimeException("Préstamo no encontrado"));
        prestamo.setEstado(EstadoPrestamo.APROBADO);
        prestamo.setMontoAprobado(montoAprobado);
        prestamo.setFechaAprobacion(LocalDate.now());
        auditoriaService.registrar(
                "ANALISTA",
                "APROBACION_PRESTAMO",
                "Préstamo aprobado ID: " + prestamo.getId());
        return prestamoRepository.save(prestamo);
    }
    // DESEMBOLSAR
    public Prestamo desembolsarPrestamo(Long idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() ->
                        new RuntimeException("Préstamo no encontrado"));
        CuentaBancaria cuenta = prestamo.getCuentaDestino();
        if (cuenta.getEstadoCuenta() != EstadoCuenta.ACTIVA) {
            throw new RuntimeException("Cuenta destino bloqueada");
        }
        cuenta.depositar(prestamo.getMontoAprobado());
        cuentaRepository.save(cuenta);
        prestamo.setEstado(EstadoPrestamo.DESEMBOLSADO);
        prestamo.setFechaDesembolso(LocalDate.now());
        auditoriaService.registrar(
                "ANALISTA",
                "DESEMBOLSO_PRESTAMO",
                "Desembolso préstamo ID: " + prestamo.getId());
        return prestamoRepository.save(prestamo);
    }
    // CANCELAR
    public Prestamo cancelarPrestamo(Long idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() ->
                        new RuntimeException("Préstamo no encontrado"));
        if (prestamo.getEstado() == EstadoPrestamo.DESEMBOLSADO) {
            throw new RuntimeException("No se puede cancelar un préstamo ya desembolsado");
        }
        prestamo.setEstado(EstadoPrestamo.CANCELADO);
        auditoriaService.registrar(
                "CLIENTE",
                "CANCELACION_PRESTAMO",
                "Préstamo cancelado ID: " + prestamo.getId());
        return prestamoRepository.save(prestamo);
    }
}