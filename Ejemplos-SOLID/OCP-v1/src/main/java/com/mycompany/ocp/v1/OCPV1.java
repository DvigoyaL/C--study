/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ocp.v1;

/**
 *
 * @author Usuario
 */
public class OCPV1 {

    public static void main(String[] args) {
    Automovil carroCamioneta = new Automovil("TYX345", "SUV", "Negro", 2022, "Toyota", 20000);
    Concesionario concesionario = new Concesionario("Max autos");
    concesionario.generarInventario();
    concesionario.MostrarAutomovil();
    Vendedor Juan = new Vendedor(carroCamioneta, 10224554, "Juan Lopez", "3142468456");
    Cliente David = new Cliente(100245785, "David Lopez", "3152871245");
    David.comprarAutomovil(David.escogerAutomovil(concesionario.getInventario()));
    concesionario.venderAutomovil();   
    concesionario.comprarAutomovil(Juan.ventaAutomovil());
    }
}
