package infraestructura.repository;

import dominio.modelo.Prestamo;
import dominio.puertos.PrestamoRepository;

public class PrestamoRepositoryImpl implements PrestamoRepository {

    @Override
    public void guardar(Prestamo prestamo) {
        System.out.println("Prestamo guardado correctamente");
    }
}