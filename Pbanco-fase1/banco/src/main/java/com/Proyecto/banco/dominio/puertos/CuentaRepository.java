package com.Proyecto.banco.dominio.puertos;

import com.Proyecto.banco.dominio.modelo.CuentaBancaria;

public interface CuentaRepository {
    void guardar(CuentaBancaria cuenta);
    CuentaBancaria buscarPorNumero(String numeroCuenta);
}