/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona{
    private Automovil carroPropio;

    public Cliente(int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.carroPropio = null;
    }
    
    public Automovil escogerAutomovil(List<Automovil> listaCarros){
        System.out.println("El carro dispuesto a comprar es: " + listaCarros.get(0).toString());
        return listaCarros.get(0);
    }
    
    public void comprarAutomovil(Automovil carroaComprar){
        System.out.println("Se ha comprado el carro de placa " + carroaComprar.getPlaca() + " en " + carroaComprar.getValorMercado());
        carroPropio = carroaComprar;
        
    };
    
}
