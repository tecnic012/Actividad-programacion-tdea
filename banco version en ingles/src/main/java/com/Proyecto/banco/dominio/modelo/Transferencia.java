package com.Proyecto.banco.dominio.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.Proyecto.banco.dominio.enums.EstadoTransferencia;

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
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CUENTA ORIGEN
    @ManyToOne
    @JoinColumn(name = "cuenta_origen_id")
    private CuentaBancaria cuentaOrigen;

    // CUENTA DESTINO
    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private CuentaBancaria cuentaDestino;

    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaAprobacion;

    @Enumerated(EnumType.STRING)
    private EstadoTransferencia estado;

    // USUARIO QUE CREA
    @ManyToOne
    @JoinColumn(name = "creador_id")
    private Usuario creador;

    // USUARIO QUE APRUEBA
    @ManyToOne
    @JoinColumn(name = "aprobador_id")
    private Usuario aprobador;

    public Transferencia() {
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public CuentaBancaria getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(CuentaBancaria cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public CuentaBancaria getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(CuentaBancaria cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(LocalDateTime fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public EstadoTransferencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoTransferencia estado) {
        this.estado = estado;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Usuario getAprobador() {
        return aprobador;
    }

    public void setAprobador(Usuario aprobador) {
        this.aprobador = aprobador;
    }
}