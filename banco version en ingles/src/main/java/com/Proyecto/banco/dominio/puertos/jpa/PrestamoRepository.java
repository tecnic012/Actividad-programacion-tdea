package com.Proyecto.banco.dominio.puertos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.banco.dominio.modelo.Prestamo;

public interface PrestamoRepository
        extends JpaRepository<Prestamo, Long> {
}