package com.Proyecto.banco.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Proyecto.banco.dominio.enums.EstadoPrestamo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El tipo de préstamo es obligatorio")
    private String tipoPrestamo;

    // CLIENTE QUE SOLICITA
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @Positive(message = "El monto solicitado debe ser mayor a cero")
    private BigDecimal montoSolicitado;

    private BigDecimal montoAprobado;

    @Positive(message = "La tasa debe ser mayor a cero")
    private BigDecimal tasaInteres;

    @Positive(message = "El plazo debe ser mayor a cero")
    private int plazoMeses;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;

    private LocalDate fechaAprobacion;

    private LocalDate fechaDesembolso;

    // CUENTA DESTINO DEL DINERO
    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private CuentaBancaria cuentaDestino;

    public Prestamo() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(BigDecimal montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public BigDecimal getMontoAprobado() {
        return montoAprobado;
    }

    public void setMontoAprobado(BigDecimal montoAprobado) {
        this.montoAprobado = montoAprobado;
    }

    public BigDecimal getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public LocalDate getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDate fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public LocalDate getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(LocalDate fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
}