/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.controller;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.Proyecto.banco.dominio.modelo.Prestamo;
import com.Proyecto.banco.services.PrestamoService;
@RestController
@RequestMapping("/loans")
public class LoanController {
    private final PrestamoService prestamoService;
    public LoanController(
            PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }
    // SOLICITAR PRÉSTAMO
    @PostMapping
    public Prestamo solicitarPrestamo(
            @RequestBody Prestamo prestamo) {
        return prestamoService.solicitarPrestamo(prestamo);
    }
    // APROBAR
    @PreAuthorize("hasAuthority('ANALISTA_INTERNO')")
    @PutMapping("/{id}/approve")
    public Prestamo aprobarPrestamo(
            @PathVariable Long id,
            @RequestParam BigDecimal montoAprobado) {
        return prestamoService.aprobarPrestamo(
                id,
                montoAprobado);
    }
    // DESEMBOLSAR
    @PreAuthorize("hasAuthority('ANALISTA_INTERNO')")
    @PutMapping("/{id}/disburse")
    public Prestamo desembolsarPrestamo(
            @PathVariable Long id) {
        return prestamoService.desembolsarPrestamo(id);
    }
    // CANCELAR
    @PutMapping("/{id}/cancel")
    public Prestamo cancelarPrestamo(
            @PathVariable Long id) {
        return prestamoService.cancelarPrestamo(id);
    }
}