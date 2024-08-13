/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public class OCPV2 {

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario("Max - Autos");
        concesionario.generarInventario();
        concesionario.MostrarInventario();
        Cliente david = new Cliente(14557452, "David Vigoya", "31457854");
        david.escogerAutomovil(concesionario.getInventario());
    }
}
