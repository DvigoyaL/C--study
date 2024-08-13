/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public class ISPV2 {

    public static void main(String[] args) {
        VehiculoCuatroRuedas carro = new Automovil("Sedán", 4, "Gasolina", "ABC123", 25000, "Plateado", 2022, "Toyota");
        VehiculoMayorACuatroRuedas bus = new Bus(1, 35, "XYZ789", 120000, "Rojo", 2021, "Volvo");        
        Concesionario concesionario = new Concesionario("Max - Autos");
        concesionario.generarInventario();
        concesionario.MostrarInventario();
        Cliente david = new Cliente(14557452, "David Vigoya", "31457854");
        david.escogerAutomovil(concesionario.getInventario());
        carro.cargarMercancia();
        bus.bajarPasajero();
    }
}
