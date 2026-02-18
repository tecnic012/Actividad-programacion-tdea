/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orden {
    private static List<String> ordenesExistentes = new ArrayList<>();

    private String numeroOrden;
    private String cedulaPaciente;
    private String cedulaMedico;
    private LocalDate fecha;
    private List<Itemorden> items = new ArrayList<>();

    public Orden(String numeroOrden, String cedulaPaciente, String cedulaMedico) {

        if (ordenesExistentes.contains(numeroOrden)) {
            throw new IllegalArgumentException("Número de orden ya existe");
        }

        ordenesExistentes.add(numeroOrden);

        this.numeroOrden = numeroOrden;
        this.cedulaPaciente = cedulaPaciente;
        this.cedulaMedico = cedulaMedico;
        this.fecha = LocalDate.now();
    }

    public void agregarItem(Itemorden item) {

        for (Itemorden i : items) {
            if (i.getItem() == item.getItem()) {
                throw new IllegalArgumentException("Item repetido en la orden");
            }
        }

        items.add(item);
    }

    public List<Itemorden> getItems() {
        return items;
    }
}
