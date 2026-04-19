package dominio.puertos;

import dominio.modelo.Transferencia;

public interface TransferenciaRepository {
    void guardar(Transferencia transferencia);
}