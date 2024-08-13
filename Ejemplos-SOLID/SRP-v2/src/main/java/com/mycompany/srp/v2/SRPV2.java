/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.srp.v2;

/**
 *
 * @author Usuario
 */
public class SRPV2 {

    public static void main(String[] args) {
    Mecanico JuanMecanico = new Mecanico(10224554, "Juan Lopez", "3142468456");
    Automovil Mazda = new Automovil("IZV427", "Sedan", "Gris", 2017, "Mazda");
    Propietario David = new Propietario(Mazda, 100245785, "David Lopez", "3152871245");
    Mazda.encender();
    David.conducir();
    Mazda.acelerar();
    JuanMecanico.cambiarAceite(Mazda);
    }
}
