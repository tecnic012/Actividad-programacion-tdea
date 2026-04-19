package dominio.puertos;

import dominio.modelo.CuentaBancaria;

public interface CuentaRepository {
    void guardar(CuentaBancaria cuenta);
    CuentaBancaria buscarPorNumero(String numeroCuenta);
}