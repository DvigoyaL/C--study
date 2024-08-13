/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.isp.v1;

/**
 *
 * @author Usuario
 */
public class ISPV1 {

    public static void main(String[] args) {
        VehiculoCuatroRuedasOMayor carro = new Automovil("Sedán", 4, "Gasolina", "ABC123", 25000, "Plateado", 2022, "Toyota");
        VehiculoCuatroRuedasOMayor bus = new Bus(60, 1, 3, "Gasolina", "XYZ789", 120000, "Rojo", 2021, "Volvo");
        carro.anunciarParada();
        carro.cargarMercancia();
        bus.anunciarParada();
        bus.cargarMercancia();
        Concesionario concesionario = new Concesionario("Max - Autos");
        concesionario.generarInventario();
        concesionario.MostrarInventario();
        Cliente david = new Cliente(14557452, "David Vigoya", "31457854");
        david.escogerAutomovil(concesionario.getInventario());
    }
}
