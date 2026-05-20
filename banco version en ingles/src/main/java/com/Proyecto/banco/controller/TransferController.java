/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import com.Proyecto.banco.dominio.modelo.Transferencia;
import com.Proyecto.banco.services.TransferenciaService;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferenciaService transferenciaService;

    public TransferController(
            TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PreAuthorize("hasAnyAuthority('CLIENTE_PERSONA_NATURAL','CLIENTE_EMPRESA')")
    @PostMapping
    public Transferencia transferir(
            @RequestParam String cuentaOrigen,
            @RequestParam String cuentaDestino,
            @RequestParam BigDecimal monto) {

        return transferenciaService.transferir(
                cuentaOrigen,
                cuentaDestino,
                monto);
    }
}