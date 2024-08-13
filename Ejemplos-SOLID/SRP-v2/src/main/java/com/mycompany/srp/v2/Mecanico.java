/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srp.v2;

/**
 *
 * @author Usuario
 */
public class Mecanico extends Persona{

    public Mecanico(int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
    }    

    public void checarAceite(Automovil carroPorRevisar){
        System.out.println("Revisando nivel de aceite del automovil de placa: " + carroPorRevisar.getPlaca());
    }
    
    public void cambiarAceite(Automovil carroPorRevisar){
        System.out.println("Cambiando aceite del automovil de placa: " + carroPorRevisar.getPlaca());
    }
    
}
