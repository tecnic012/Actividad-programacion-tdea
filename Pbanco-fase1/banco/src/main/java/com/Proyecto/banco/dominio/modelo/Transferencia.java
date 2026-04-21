package com.Proyecto.banco.dominio.modelo;

import com.Proyecto.banco.dominio.enums.EstadoTransferencia;

public class Transferencia {

    private int idTransferencia;
    private String cuentaOrigen;
    private String cuentaDestino;
    private double monto;
    private String fechaCreacion;
    private EstadoTransferencia estadoTransferencia;

    public Transferencia() {}

    public Transferencia(int idTransferencia, String cuentaOrigen, String cuentaDestino, double monto, String fechaCreacion, EstadoTransferencia estadoTransferencia) {
        this.idTransferencia = idTransferencia;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.estadoTransferencia = estadoTransferencia;
    }

    public int getIdTransferencia() { return idTransferencia; }
    public double getMonto() { return monto; }
}