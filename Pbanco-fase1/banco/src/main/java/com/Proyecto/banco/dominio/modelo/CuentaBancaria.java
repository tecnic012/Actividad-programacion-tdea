package com.Proyecto.banco.dominio.modelo;

import com.Proyecto.banco.dominio.enums.EstadoCuenta;

public class CuentaBancaria {

    private String numeroCuenta;
    private String tipoCuenta;
    private String idTitular;
    private double saldoActual;
    private String moneda;
    private EstadoCuenta estadoCuenta;
    private String fechaApertura;

    public CuentaBancaria() {}

    public CuentaBancaria(String numeroCuenta, String tipoCuenta, String idTitular, double saldoActual, String moneda, EstadoCuenta estadoCuenta, String fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.idTitular = idTitular;
        this.saldoActual = saldoActual;
        this.moneda = moneda;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
    }

    public String getNumeroCuenta() { return numeroCuenta; }

    public double getSaldoActual() { return saldoActual; }

    public void depositar(double monto) {
        saldoActual += monto;
    }

    public void retirar(double monto) {
        saldoActual -= monto;
    }
}