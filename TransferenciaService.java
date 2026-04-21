package com.Proyecto.banco.dominio.modelo;

public class BitacoraOperaciones {

    private String idBitacora;
    private String tipoOperacion;
    private String fechaHoraOperacion;
    private int idUsuario;
    private String rolUsuario;
    private String idProductoAfectado;
    private String datosDetalle;

    public BitacoraOperaciones() {}

    public BitacoraOperaciones(String idBitacora, String tipoOperacion, String fechaHoraOperacion, int idUsuario, String rolUsuario, String idProductoAfectado, String datosDetalle) {
        this.idBitacora = idBitacora;
        this.tipoOperacion = tipoOperacion;
        this.fechaHoraOperacion = fechaHoraOperacion;
        this.idUsuario = idUsuario;
        this.rolUsuario = rolUsuario;
        this.idProductoAfectado = idProductoAfectado;
        this.datosDetalle = datosDetalle;
    }
}