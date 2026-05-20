package com.Proyecto.banco.dominio.puertos.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Proyecto.banco.dominio.enums.EstadoTransferencia;
import com.Proyecto.banco.dominio.modelo.Transferencia;

public interface TransferenciaRepository
        extends JpaRepository<Transferencia, Long> {

    // Busca transferencias EN_ESPERA_APROBACION
    // cuya fechaCreacion sea anterior a la fecha límite
    @Query("SELECT t FROM Transferencia t " +
           "WHERE t.estado = :estado " +
           "AND t.fechaCreacion < :fechaLimite")
    List<Transferencia> findByEstadoAndFechaCreacionBefore(
            @Param("estado") EstadoTransferencia estado,
            @Param("fechaLimite") LocalDateTime fechaLimite);
}