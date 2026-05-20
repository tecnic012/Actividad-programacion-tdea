/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.banco.dominio.puertos.mongo;

import com.Proyecto.banco.bitacora.BitacoraOperacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository
        extends MongoRepository<BitacoraOperacion, String> {

}