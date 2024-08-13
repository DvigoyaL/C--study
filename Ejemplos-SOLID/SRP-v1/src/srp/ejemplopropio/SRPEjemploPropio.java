/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package srp.ejemplopropio;

/**
 *
 * @author Usuario
 */
public class SRPEjemploPropio {

    public static void main(String[] args) {
    Automovil miCarro = new Automovil("Sedan", "Rojo", 2018, "Mazda");
    System.out.println(miCarro.toString());
    miCarro.encender();
    miCarro.acelerar();
    miCarro.checarAceite();
    }
    
}
