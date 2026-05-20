/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter
        extends OncePerRequestFilter {

    private static final String SECRET =
            "MiClaveSuperSeguraParaProyectoBancario2026";

    @Override
    protected void doFilterInternal(

            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)

            throws ServletException, IOException {

        String authHeader =
                request.getHeader("Authorization");

        // SI NO HAY TOKEN
        if (authHeader == null
                || !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);

            return;
        }

        try {

            String token =
                    authHeader.substring(7);

            Claims claims = Jwts.parserBuilder()

                    .setSigningKey(
                            SECRET.getBytes())

                    .build()

                    .parseClaimsJws(token)

                    .getBody();

            String correo =
                    claims.getSubject();

            String rol =
                    claims.get("rol", String.class);

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(

                            correo,

                            null,

                            List.of(
                                    new SimpleGrantedAuthority(
                                            rol)));

            SecurityContextHolder
                    .getContext()
                    .setAuthentication(auth);

        } catch (Exception e) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED);

            return;
        }

        filterChain.doFilter(request, response);
    }
}