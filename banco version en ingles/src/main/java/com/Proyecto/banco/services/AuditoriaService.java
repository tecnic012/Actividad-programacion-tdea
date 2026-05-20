/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.Proyecto.banco.dominio.modelo.Auditoria;
import com.Proyecto.banco.dominio.puertos.jpa.AuditoriaRepository;

@Service
public class AuditoriaService {

    private final AuditoriaRepository repository;

    public AuditoriaService(
            AuditoriaRepository repository) {

        this.repository = repository;
    }

    public void registrar(
            String usuario,
            String accion,
            String detalle) {

        Auditoria auditoria = new Auditoria(

                usuario,
                accion,
                detalle,
                LocalDateTime.now());

        repository.save(auditoria);
    }
}