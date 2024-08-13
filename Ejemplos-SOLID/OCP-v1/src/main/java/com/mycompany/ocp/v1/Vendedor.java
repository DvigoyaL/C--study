/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v1;

/**
 *
 * @author Usuario
 */
public class Vendedor extends Persona {
private Automovil carroPorVender;

    public Vendedor(Automovil carroPorVender, int cedula, String nombre, String telefono) {
        super(cedula, nombre, telefono);
        this.carroPorVender = carroPorVender;
    }

    public Automovil ventaAutomovil(){
    System.out.println("Vehiculo vendido a el concesionario");
    Automovil getCarroVendido = carroPorVender;
    carroPorVender = null;
    return getCarroVendido;
    }

    @Override
    public String toString() {
        return "Vendedor{" + nombre + ", carroPorVender=" + carroPorVender + '}';
    }

}
