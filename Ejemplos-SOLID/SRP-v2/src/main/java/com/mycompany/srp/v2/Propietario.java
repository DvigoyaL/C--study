/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srp.v2;

/**
 *
 * @author Usuario
 */
public class Propietario extends Persona {
    private Automovil carroPropio;

    public Propietario(Automovil carroPropio, int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.carroPropio = carroPropio;
    }
    
    public void conducir(){
        System.out.println("Conduciendo mi " + carroPropio.getReferencia() + " " + carroPropio.getColor());   
    }
    
    public void cambiarMoto(){
    System.out.println("Manejando moto");
    }
}
