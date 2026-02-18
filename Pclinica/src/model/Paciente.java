/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

public class Paciente {
      private String usuario;
    private String password;
    private String cedula;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private Seguro seguro;
    private ContactoEmergencia contactoEmergencia;
    private double copagoAcumuladoAnual;

    public Paciente(String usuario, String password, String cedula,
                    String nombreCompleto, LocalDate fechaNacimiento) {
        this.usuario = usuario;
        this.password = password;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.copagoAcumuladoAnual = 0;
    }

    public String getCedula() {
        return cedula;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public double getCopagoAcumuladoAnual() {
        return copagoAcumuladoAnual;
    }

    public void sumarCopago(double valor) {
        this.copagoAcumuladoAnual += valor;
    }

    
}
