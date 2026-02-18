/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author steve
 */
public class Itemorden {
      private int item;
    private String nombre;
    private double costo;
    private String tipo; // MEDICAMENTO, PROCEDIMIENTO, AYUDA

    public Itemorden(int item, String nombre, double costo, String tipo) {
        this.item = item;
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }

    public int getItem() {
        return item;
    }

    public double getCosto() {
        return costo;
    }

    public String getTipo() {
        return tipo;
    }
}
