package pbanco;

import dominio.modelo.CuentaBancaria;
import dominio.enums.EstadoCuenta;
import dominio.services.TransferenciaService;
import dominio.services.PrestamoService;

import java.util.Scanner;

public class PBanco {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria(
                "1111",
                "Ahorros",
                "1001",
                500000,
                "COP",
                EstadoCuenta.ACTIVA,
                "01/01/2026"
        );

     

        TransferenciaService transferenciaService = new TransferenciaService();
        PrestamoService prestamoService = new PrestamoService();

        int opcion;

        do{

            System.out.println("\n=== SISTEMA BANCO ===");
            System.out.println("1. Ver saldo de la cuenta ");
            System.out.println("2. Depositar a la cuenta ");
            System.out.println("3. Retirar de cuenta ");
            System.out.println("5. Desembolsar prestamo ");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch(opcion){

                case 1:
                    System.out.println("Saldo de la cuenta : " + cuenta1.getSaldoActual());
                    break;

                case 2:
                    System.out.print("Monto a depositar: ");
                    double dep = sc.nextDouble();
                    cuenta1.depositar(dep);
                    break;

                case 3:
                    System.out.print("Monto a retirar: ");
                    double ret = sc.nextDouble();
                    cuenta1.retirar(ret);
                    break;

      

                case 5:
                    System.out.print("Monto del prestamo: ");
                    double prestamo = sc.nextDouble();

                    prestamoService.desembolsarPrestamo(cuenta1, prestamo);

                    System.out.println("Prestamo depositado en la cuenta");
                    break;

            }

        }while(opcion != 0);

    }

}