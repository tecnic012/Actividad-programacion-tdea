/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author steve
 */
public class Usuario {
  protected String nombreCompleto;
    protected String cedula;
    protected String correo;
    protected String telefono;
    protected String rol;

    public Usuario(String nombreCompleto, String cedula, String correo, String telefono, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }

    public String getCedula() {
        return cedula;
    }

    public String getRol() {
        return rol;
    }
}
