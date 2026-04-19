package dominio.puertos;

import dominio.modelo.Prestamo;

public interface PrestamoRepository {
    void guardar(Prestamo prestamo);
}