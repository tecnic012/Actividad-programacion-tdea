

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.services;

import java.math.BigDecimal;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;
import com.Proyecto.banco.dominio.puertos.jpa.CuentaRepository;

import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    private final CuentaRepository repository;

    public CuentaService(CuentaRepository repository) {
        this.repository = repository;
    }

    // GUARDAR CUENTA
    public void guardar(CuentaBancaria cuenta) {
        repository.save(cuenta);
    }

    // BUSCAR CUENTA
    public CuentaBancaria buscarPorNumero(String numero) {

        return repository.findById(numero)
                .orElse(null);
    }

    // DEPOSITAR
    public CuentaBancaria depositar(String numero, BigDecimal monto) {

        CuentaBancaria cuenta = repository.findById(numero)
                .orElse(null);

        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        cuenta.depositar(monto);

        return repository.save(cuenta);
    }

    // RETIRAR
    public CuentaBancaria retirar(String numero, BigDecimal monto) {

        CuentaBancaria cuenta = repository.findById(numero)
                .orElse(null);

        if (cuenta == null) {
            throw new RuntimeException("Cuenta no encontrada");
        }

        cuenta.retirar(monto);

        return repository.save(cuenta);
    }
}