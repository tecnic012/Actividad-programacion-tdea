package dominio.services;

import dominio.modelo.CuentaBancaria;

public class PrestamoService {

    public void desembolsarPrestamo(CuentaBancaria cuentaDestino, double monto){
        cuentaDestino.depositar(monto);
    }

}