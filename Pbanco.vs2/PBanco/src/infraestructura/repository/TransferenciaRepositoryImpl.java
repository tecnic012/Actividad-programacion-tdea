package infraestructura.repository;

import dominio.modelo.Transferencia;
import dominio.puertos.TransferenciaRepository;

public class TransferenciaRepositoryImpl implements TransferenciaRepository {

    @Override
    public void guardar(Transferencia transferencia) {
        System.out.println("Transferencia guardada correctamente");
    }
}