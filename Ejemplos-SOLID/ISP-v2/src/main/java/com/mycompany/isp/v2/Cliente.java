/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cliente extends Persona{
    private Vehiculo vehiculoPropio;

    public Cliente(int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.vehiculoPropio = null;
    }
    
    public Vehiculo escogerAutomovil(List<Vehiculo> listaVehiculos){
        System.out.println("El carro dispuesto a comprar es: " + listaVehiculos.get(0).toString());
        return listaVehiculos.get(0);
    }
    
    public void comprarAutomovil(Vehiculo vehiculoaComprar){
        System.out.println("Se ha comprado el carro de placa " + vehiculoaComprar.getPlaca() + " en " + vehiculoaComprar.getValorMercado());
        vehiculoPropio = vehiculoaComprar;
        
    };
    
}
