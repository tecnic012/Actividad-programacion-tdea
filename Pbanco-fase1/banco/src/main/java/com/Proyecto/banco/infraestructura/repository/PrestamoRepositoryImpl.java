package com.Proyecto.banco.infraestructura.repository;

import com.Proyecto.banco.dominio.modelo.Prestamo;
import com.Proyecto.banco.dominio.puertos.PrestamoRepository;

public class PrestamoRepositoryImpl implements PrestamoRepository {

    @Override
    public void guardar(Prestamo prestamo) {
        System.out.println("Prestamo guardado correctamente");
    }
}