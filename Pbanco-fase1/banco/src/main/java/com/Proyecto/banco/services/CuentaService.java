

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.services;

import org.springframework.stereotype.Service;
import com.Proyecto.banco.dominio.modelo.CuentaBancaria;

@Service
public class CuentaService {

    private CuentaBancaria cuenta = new CuentaBancaria(
        "123", "Ahorros", "001", 1000, "COP", null, "01/01/2026"
    );

    public double verSaldo() {
        return cuenta.getSaldoActual();
    }

    public void depositar(double monto) {
        cuenta.depositar(monto);
    }

    public void retirar(double monto) {
        cuenta.retirar(monto);
    }
}
