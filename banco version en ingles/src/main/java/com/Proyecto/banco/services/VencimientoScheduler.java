/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Proyecto.banco.bitacora.BitacoraService;
import com.Proyecto.banco.dominio.enums.EstadoTransferencia;
import com.Proyecto.banco.dominio.modelo.Transferencia;
import com.Proyecto.banco.dominio.puertos.jpa.TransferenciaRepository;

@Component
public class VencimientoScheduler {

    private final TransferenciaRepository transferenciaRepository;
    private final BitacoraService bitacoraService;

    public VencimientoScheduler(
            TransferenciaRepository transferenciaRepository,
            BitacoraService bitacoraService) {

        this.transferenciaRepository = transferenciaRepository;
        this.bitacoraService = bitacoraService;
    }

    // Se ejecuta cada 60 segundos
    @Scheduled(fixedRate = 60000)
    public void validarTransferenciasVencidas() {

        // Fecha límite: hace 1 hora
        LocalDateTime fechaLimite = LocalDateTime.now().minusHours(1);

        // Buscar transferencias en espera que superaron 1 hora
        List<Transferencia> vencidas = transferenciaRepository
                .findByEstadoAndFechaCreacionBefore(
                        EstadoTransferencia.EN_ESPERA_APROBACION,
                        fechaLimite);

        if (vencidas.isEmpty()) {
            System.out.println("===> Scheduler: no hay transferencias vencidas");
            return;
        }

        for (Transferencia t : vencidas) {

            t.setEstado(EstadoTransferencia.VENCIDA);
            transferenciaRepository.save(t);

            // Registrar en bitácora
            bitacoraService.registrar(
                    "VENCIMIENTO_TRANSFERENCIA",
                    "SISTEMA",
                    "SCHEDULER",
                    "TRANSFERENCIA",
                    Map.of(
                            "idTransferencia", t.getId(),
                            "fechaCreacion", t.getFechaCreacion().toString(),
                            "motivo", "Superó 1 hora sin aprobación"
                    )
            );

            System.out.println("===> Transferencia vencida: ID " + t.getId());
        }
    }
}