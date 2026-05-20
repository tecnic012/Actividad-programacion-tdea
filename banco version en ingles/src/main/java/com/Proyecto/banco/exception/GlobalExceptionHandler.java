/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // CUENTA NO ENCONTRADA
    @ExceptionHandler(CuentaNoEncontradaException.class)
    public ResponseEntity<ErrorResponse>
    manejarCuentaNoEncontrada(

            CuentaNoEncontradaException ex) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.NOT_FOUND.value(),

                ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // SALDO INSUFICIENTE
    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<ErrorResponse>
    manejarSaldoInsuficiente(

            SaldoInsuficienteException ex) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(error);
    }

    // VALIDACIONES
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse>
    manejarValidaciones(

            MethodArgumentNotValidException ex) {

        String mensaje = ex
                .getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                mensaje);

        return ResponseEntity
                .badRequest()
                .body(error);
    }

    // ERRORES GENERALES
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse>
    manejarRuntime(

            RuntimeException ex) {

        ErrorResponse error = new ErrorResponse(

                LocalDateTime.now(),

                HttpStatus.BAD_REQUEST.value(),

                ex.getMessage());

        return ResponseEntity
                .badRequest()
                .body(error);
    }
}