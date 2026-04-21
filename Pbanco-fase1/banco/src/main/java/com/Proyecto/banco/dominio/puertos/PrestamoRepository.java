package com.Proyecto.banco.dominio.puertos;

import com.Proyecto.banco.dominio.modelo.Prestamo;

public interface PrestamoRepository {
    void guardar(Prestamo prestamo);
}