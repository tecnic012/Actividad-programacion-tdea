package com.Proyecto.banco.infraestructura.repository;

import com.Proyecto.banco.dominio.modelo.Transferencia;
import com.Proyecto.banco.dominio.puertos.TransferenciaRepository;

public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Override
    public void guardar(Transferencia transferencia) {
        System.out.println("Transferencia guardada correctamente");
    }
}