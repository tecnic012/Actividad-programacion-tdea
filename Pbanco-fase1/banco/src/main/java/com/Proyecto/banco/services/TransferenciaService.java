package com.Proyecto.banco.services;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;

public class TransferenciaService {

    public boolean transferir(CuentaBancaria origen, CuentaBancaria destino, double monto){

        if(origen.getSaldoActual() >= monto){
            origen.retirar(monto);
            destino.depositar(monto);
            return true;
        }

        return false;
    }

}