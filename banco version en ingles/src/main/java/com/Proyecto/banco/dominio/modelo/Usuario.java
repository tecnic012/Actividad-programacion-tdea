/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.dominio.modelo;

import com.Proyecto.banco.dominio.enums.EstadoUsuario;
import com.Proyecto.banco.dominio.enums.RolSistema;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre completo es obligatorio")
    private String nombreCompleto;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    @Column(unique = true, nullable = false)
    @Email(message = "El correo debe tener formato válido")
    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    // ✅ Teléfono: mínimo 7, máximo 15 caracteres
    @Size(min = 7, max = 15, message = "El teléfono debe tener entre 7 y 15 caracteres")
    private String telefono;

    private String direccion;

    @NotBlank(message = "El password es obligatorio")
    private String password;

    @Enumerated(EnumType.STRING)
    private RolSistema rol;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estadoUsuario;

    // ✅ NUEVO: fecha de nacimiento para validar mayor de edad
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser en el pasado")
    private LocalDate fechaNacimiento;

    public Usuario() {
    }

    // ✅ Método que valida si el usuario es mayor de edad
    public boolean esMayorDeEdad() {
        if (fechaNacimiento == null) return false;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolSistema getRol() {
        return rol;
    }

    public void setRol(RolSistema rol) {
        this.rol = rol;
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}