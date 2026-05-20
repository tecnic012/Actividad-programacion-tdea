/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;

import java.math.BigDecimal;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;
import com.Proyecto.banco.services.CuentaService;
import com.Proyecto.banco.exception.CuentaNoEncontradaException;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final CuentaService service;

    public AccountController(CuentaService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyAuthority('ANALISTA_INTERNO', 'EMPLEADO_VENTANILLA', 'EMPLEADO_COMERCIAL')")
    @PostMapping
    public CuentaBancaria crear(@Valid @RequestBody CuentaBancaria cuenta){

        service.guardar(cuenta);

        return cuenta;
    }

    @PreAuthorize("hasAnyAuthority('ANALISTA_INTERNO', 'EMPLEADO_VENTANILLA', 'EMPLEADO_COMERCIAL', 'CLIENTE_PERSONA_NATURAL', 'CLIENTE_EMPRESA')")
    @GetMapping("/{numero}")
    public CuentaBancaria buscar(@PathVariable String numero) {

        CuentaBancaria cuenta = service.buscarPorNumero(numero);

        if (cuenta == null) {
            throw new CuentaNoEncontradaException("Cuenta no encontrada");
        }

        return cuenta;
    }
    
    @PreAuthorize("hasAnyAuthority('ANALISTA_INTERNO', 'EMPLEADO_VENTANILLA')")
    @PostMapping("/{numero}/depositar")
    public CuentaBancaria depositar(
            @PathVariable String numero,
            @RequestParam BigDecimal monto) {

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe ser mayor a 0");
        }

        return service.depositar(numero, monto);
    }
    
     @PreAuthorize("hasAnyAuthority('ANALISTA_INTERNO', 'EMPLEADO_VENTANILLA')")
    @PostMapping("/{numero}/retirar")
    public CuentaBancaria retirar(
            @PathVariable String numero,
            @RequestParam BigDecimal monto) {

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe ser mayor a 0");
        }

        return service.retirar(numero, monto);
    }
}