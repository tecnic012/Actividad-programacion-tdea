/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

    private LocalDateTime fecha;

    private int status;

    private String error;

    public ErrorResponse(
            LocalDateTime fecha,
            int status,
            String error) {

        this.fecha = fecha;
        this.status = status;
        this.error = error;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}