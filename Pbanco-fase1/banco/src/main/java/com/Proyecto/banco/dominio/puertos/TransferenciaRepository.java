package com.Proyecto.banco.dominio.puertos;

import com.Proyecto.banco.dominio.modelo.Transferencia;

public interface TransferenciaRepository {
    void guardar(Transferencia transferencia);
}