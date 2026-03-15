package dominio.services;

import dominio.modelo.CuentaBancaria;

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