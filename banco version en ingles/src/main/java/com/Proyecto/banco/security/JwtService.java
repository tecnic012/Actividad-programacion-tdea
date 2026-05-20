/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private static final String SECRET =
            "MiClaveSuperSeguraParaProyectoBancario2026";

    private final Key key = Keys.hmacShaKeyFor(
            SECRET.getBytes());

    public String generarToken(String correo, String rol) {

        return Jwts.builder()

                .setSubject(correo)

                .claim("rol", rol)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(System.currentTimeMillis()
                                + 1000 * 60 * 60))

                .signWith(key, SignatureAlgorithm.HS256)

                .compact();
    }

    public String extraerCorreo(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(key)

                .build()

                .parseClaimsJws(token)

                .getBody()

                .getSubject();
    }
}