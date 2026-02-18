/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author steve
 */
public class Validacionservicio {
     public static boolean validarPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$");
    }

    public static boolean validarCorreo(String correo) {
        return correo.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
