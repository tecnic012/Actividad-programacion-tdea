/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.Proyecto.banco.dominio.modelo.Usuario;
import com.Proyecto.banco.dominio.puertos.jpa.UsuarioRepository;
import com.Proyecto.banco.security.JwtService;
import com.Proyecto.banco.dto.LoginRequest;
import com.Proyecto.banco.dto.LoginResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(
            UsuarioRepository usuarioRepository,
            JwtService jwtService,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    // ─────────────────────────────────────────
    // LOGIN
    // ─────────────────────────────────────────
    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByCorreo(request.getCorreo())
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword())) {

            throw new RuntimeException("Password incorrecto");
        }

        String token = jwtService.generarToken(
                usuario.getCorreo(),
                usuario.getRol().name());

        return new LoginResponse(token);
    }

    // ─────────────────────────────────────────
    // REGISTRO
    // ─────────────────────────────────────────
    @PostMapping("/record")
    public String record(
            @Valid @RequestBody Usuario usuario) {

        // TEMPORAL — verificar que llega la fecha
        System.out.println("===> Fecha nacimiento: " + usuario.getFechaNacimiento());
        System.out.println("===> Mayor de edad: " + usuario.esMayorDeEdad());

        // Verificar que el correo no exista ya
        if (usuarioRepository.findByCorreo(
                usuario.getCorreo()).isPresent()) {
            throw new RuntimeException(
                    "Ya existe un usuario con ese correo");
        }

        // Validar que sea mayor de edad
        if (!usuario.esMayorDeEdad()) {
            throw new RuntimeException(
                    "El usuario debe ser mayor de 18 años");
        }

        // Encriptar el password antes de guardar
        usuario.setPassword(
                passwordEncoder.encode(usuario.getPassword()));

        usuarioRepository.save(usuario);

        return "Usuario registrado correctamente";
    }
}