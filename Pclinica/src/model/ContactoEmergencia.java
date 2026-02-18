/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author steve
 */
public class ContactoEmergencia {
     private String nombres;
    private String apellidos;
    private String relacion;
    private String telefono;

    public ContactoEmergencia(String nombres, String apellidos,
                              String relacion, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.relacion = relacion;
        this.telefono = telefono;
    } 
}
