/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public class Vendedor extends Persona {
private Vehiculo vehiculoPorVender;

    public Vendedor(Vehiculo vehiculoPorVender, int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.vehiculoPorVender = vehiculoPorVender;
    }

    public Vehiculo ventaAutomovil(){
    System.out.println("Vehiculo vendido a el concesionario");
    Vehiculo getVehiculoVendido = vehiculoPorVender;
    vehiculoPorVender = null;
    return getVehiculoVendido;
    }

    @Override
    public String toString() {
        return "Vendedor{" + nombre + ", vehiculo a vender=" + vehiculoPorVender + '}';
    }

}
