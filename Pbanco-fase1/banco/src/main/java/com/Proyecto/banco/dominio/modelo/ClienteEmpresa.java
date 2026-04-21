package com.Proyecto.banco.dominio.modelo;

public class ClienteEmpresa {

    private String razonSocial;
    private String nit;
    private String correo;
    private String telefono;
    private String direccion;
    private String representanteLegal;

    public ClienteEmpresa() {}

    public ClienteEmpresa(String razonSocial, String nit, String correo, String telefono, String direccion, String representanteLegal) {
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.representanteLegal = representanteLegal;
    }

    public String getRazonSocial() { return razonSocial; }
    public String getNit() { return nit; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public String getRepresentanteLegal() { return representanteLegal; }
}