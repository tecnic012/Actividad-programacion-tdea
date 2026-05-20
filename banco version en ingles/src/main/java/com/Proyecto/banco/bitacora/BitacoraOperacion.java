/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.bitacora;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "bitacora")
public class BitacoraOperacion {

    @Id
    private String id;

    private String tipoOperacion;
    private LocalDateTime fechaHora;
    private String usuario;
    private String rolUsuario;
    private String productoAfectado;
    private Map<String, Object> datosDetalle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getProductoAfectado() {
        return productoAfectado;
    }

    public void setProductoAfectado(String productoAfectado) {
        this.productoAfectado = productoAfectado;
    }

    public Map<String, Object> getDatosDetalle() {
        return datosDetalle;
    }

    public void setDatosDetalle(Map<String, Object> datosDetalle) {
        this.datosDetalle = datosDetalle;
    }
}