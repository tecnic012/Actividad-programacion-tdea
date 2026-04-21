package com.Proyecto.banco.dominio.modelo;

import com.Proyecto.banco.dominio.enums.EstadoPrestamo;

public class Prestamo {

    private int idPrestamo;
    private String tipoPrestamo;
    private String idClienteSolicitante;
    private double montoSolicitado;
    private double montoAprobado;
    private double tasaInteres;
    private int plazoMeses;
    private EstadoPrestamo estadoPrestamo;

    public Prestamo() {}

    public Prestamo(int idPrestamo, String tipoPrestamo, String idClienteSolicitante, double montoSolicitado, double tasaInteres, int plazoMeses, EstadoPrestamo estadoPrestamo) {
        this.idPrestamo = idPrestamo;
        this.tipoPrestamo = tipoPrestamo;
        this.idClienteSolicitante = idClienteSolicitante;
        this.montoSolicitado = montoSolicitado;
        this.tasaInteres = tasaInteres;
        this.plazoMeses = plazoMeses;
        this.estadoPrestamo = estadoPrestamo;
    }

    public int getIdPrestamo() { return idPrestamo; }
    public double getMontoSolicitado() { return montoSolicitado; }
}