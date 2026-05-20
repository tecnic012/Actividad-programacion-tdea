/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;

import com.Proyecto.banco.bitacora.BitacoraOperacion;
import com.Proyecto.banco.dominio.puertos.mongo.BitacoraRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private final BitacoraRepository bitacoraRepository;

    public TestController(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    @GetMapping("/mongo")
    public String testMongo() {

        BitacoraOperacion b = new BitacoraOperacion();
        b.setTipoOperacion("TEST");
        b.setFechaHora(LocalDateTime.now());
        b.setUsuario("SYSTEM");
        b.setRolUsuario("ADMIN");
        b.setProductoAfectado("PRUEBA");

        b.setDatosDetalle(Map.of(
                "mensaje", "verificando mongo"
        ));

        bitacoraRepository.save(b);

        return "OK";
    }
}