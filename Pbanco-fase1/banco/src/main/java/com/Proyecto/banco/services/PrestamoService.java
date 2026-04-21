package com.Proyecto.banco.services;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;

public class PrestamoService {

    public void desembolsarPrestamo(CuentaBancaria cuentaDestino, double monto){
        cuentaDestino.depositar(monto);
    }

}