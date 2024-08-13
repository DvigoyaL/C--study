/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public abstract class VehiculoDosRuedas extends Vehiculo{
    private final int numeroLlantas;
    public VehiculoDosRuedas(String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        numeroLlantas = 2;
    }

    @Override
    public String toString() {
        return "VehiculoDosRuedas{" + "numeroLlantas=" + numeroLlantas + '}';
    }
    
    public abstract void usarCaballete();
    public abstract void manejoEnTrafico();
}
