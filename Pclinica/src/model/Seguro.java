/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

public class Seguro {
    private String nombreCompania;
    private String numeroPoliza;
    private boolean activa;
    private LocalDate fechaFin;

    public Seguro(String nombreCompania, String numeroPoliza,
                  boolean activa, LocalDate fechaFin) {
        this.nombreCompania = nombreCompania;
        this.numeroPoliza = numeroPoliza;
        this.activa = activa;
        this.fechaFin = fechaFin;
    }

    public boolean isActiva() {
        return activa && fechaFin.isAfter(LocalDate.now());
    }
}
