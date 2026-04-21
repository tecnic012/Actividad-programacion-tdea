/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;

import org.springframework.web.bind.annotation.*;
import com.Proyecto.banco.services.CuentaService;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService service;

    public CuentaController(CuentaService service) {
        this.service = service;
    }

    @GetMapping("/saldo")
    public double saldo() {
        return service.verSaldo();
    }

    @PostMapping("/depositar")
    public String depositar(@RequestParam double monto) {
        service.depositar(monto);
        return "Depósito realizado";
    }

    @PostMapping("/retirar")
    public String retirar(@RequestParam double monto) {
        service.retirar(monto);
        return "Retiro realizado";
    }
}