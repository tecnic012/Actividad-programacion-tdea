/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.HashMap;
import java.util.Map;

public class Historiaclinica {
    private Map<String, Map<String, String>> historia = new HashMap<>();

    public void agregarRegistro(String cedulaPaciente, String fecha, String diagnostico) {

        historia.putIfAbsent(cedulaPaciente, new HashMap<>());
        historia.get(cedulaPaciente).put(fecha, diagnostico);
    }

    public void mostrarHistoria(String cedulaPaciente) {
        System.out.println(historia.get(cedulaPaciente));
    }
}
