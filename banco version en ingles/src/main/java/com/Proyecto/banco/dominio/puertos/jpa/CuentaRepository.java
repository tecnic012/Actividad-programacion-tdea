package com.Proyecto.banco.dominio.puertos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;

public interface CuentaRepository
        extends JpaRepository<CuentaBancaria, String> {
}