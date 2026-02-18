/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import model.*;
import servicio.*;
import java.time.LocalDate;

public class Principal {
    
      public static void main(String[] args) {

        Paciente paciente = new Paciente(
                "usuario1",
                "Password1@",
                "123456",
                "Juan Perez",
                LocalDate.of(1990, 5, 10)
        );

        Seguro seguro = new Seguro(
                "Sura",
                "POL123",
                true,
                LocalDate.of(2026, 12, 31)
        );

        paciente.setSeguro(seguro);

        Orden orden = new Orden("000001", "123456", "999999");

        orden.agregarItem(new Itemorden(1, "Paracetamol", 20000, "MEDICAMENTO"));
        orden.agregarItem(new Itemorden(2, "Radiografía", 80000, "PROCEDIMIENTO"));

        Facturacionservicio facturacion = new Facturacionservicio();
        facturacion.generarFactura(paciente, orden);
    }
}
