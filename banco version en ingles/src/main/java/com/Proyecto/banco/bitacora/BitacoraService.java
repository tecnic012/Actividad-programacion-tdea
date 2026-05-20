/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.bitacora;

import com.Proyecto.banco.dominio.puertos.mongo.BitacoraRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class BitacoraService {

    private final BitacoraRepository repository;

    public BitacoraService(BitacoraRepository repository) {
        this.repository = repository;
    }

    public void registrar(
            String tipoOperacion,
            String usuario,
            String rolUsuario,
            String productoAfectado,
            Map<String, Object> detalle) {

        BitacoraOperacion bitacora = new BitacoraOperacion();

        bitacora.setTipoOperacion(tipoOperacion);
        bitacora.setFechaHora(LocalDateTime.now());
        bitacora.setUsuario(usuario);
        bitacora.setRolUsuario(rolUsuario);
        bitacora.setProductoAfectado(productoAfectado);
        bitacora.setDatosDetalle(detalle);

        repository.save(bitacora);
    }
}