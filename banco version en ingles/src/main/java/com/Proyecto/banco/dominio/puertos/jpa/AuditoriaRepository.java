/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.dominio.puertos.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto.banco.dominio.modelo.Auditoria;

public interface AuditoriaRepository
        extends JpaRepository<Auditoria, Long> {
}