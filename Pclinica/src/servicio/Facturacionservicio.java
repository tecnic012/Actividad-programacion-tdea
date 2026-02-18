/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import model.Orden;
import model.Paciente;

public class Facturacionservicio {
    
     public void generarFactura(Paciente paciente, Orden orden) {

        double total = 0;

        for (var item : orden.getItems()) {
            total += item.getCosto();
        }

        System.out.println("Total servicios: $" + total);

        if (paciente.getSeguro() != null && paciente.getSeguro().isActiva()) {

            if (paciente.getCopagoAcumuladoAnual() >= 1000000) {
                System.out.println("Copago exonerado por superar el millón anual.");
                System.out.println("Aseguradora paga: $" + total);
            } else {
                double copago = 50000;
                paciente.sumarCopago(copago);

                System.out.println("Copago paciente: $" + copago);
                System.out.println("Aseguradora paga: $" + (total - copago));
            }

        } else {
            System.out.println("Paciente paga total: $" + total);
        }
    }

   
    }

