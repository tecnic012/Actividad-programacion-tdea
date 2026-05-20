package com.Proyecto.banco.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.Proyecto.banco.dominio.enums.EstadoCuenta;
import com.Proyecto.banco.exception.SaldoInsuficienteException;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class CuentaBancaria {

    @Id
    @NotNull(message = "El número de cuenta es obligatorio")
    private String numeroCuenta;

    @NotBlank(message = "El tipo de cuenta es obligatorio")
    private String tipoCuenta;

    @ManyToOne
    @JoinColumn(name = "titular_id")
    private Usuario titular;
    
    @PositiveOrZero(message = "El saldo no puede ser negativo")
    private BigDecimal saldoActual;

    @NotBlank(message = "La moneda es obligatoria")
    private String moneda;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "El estado es obligatorio")
    private EstadoCuenta estadoCuenta;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fechaApertura;

    public CuentaBancaria() {
    }

    public CuentaBancaria(
            String numeroCuenta,
            String tipoCuenta,
            Usuario titular,
            BigDecimal saldoActual,
            String moneda,
            EstadoCuenta estadoCuenta,
            LocalDate fechaApertura) {

        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.titular = titular;
        this.saldoActual = saldoActual;
        this.moneda = moneda;
        this.estadoCuenta = estadoCuenta;
        this.fechaApertura = fechaApertura;
    }

    // GETTERS Y SETTERS

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public BigDecimal getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(BigDecimal saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public EstadoCuenta getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(EstadoCuenta estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    // MÉTODOS

    public void depositar(BigDecimal monto) {

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        saldoActual = saldoActual.add(monto);
    }

    public void retirar(BigDecimal monto) {

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero");
        }

        if (saldoActual.compareTo(monto) >= 0) {

            saldoActual = saldoActual.subtract(monto);

        } else {

            throw new SaldoInsuficienteException("Saldo insuficiente");
        }
    }
}