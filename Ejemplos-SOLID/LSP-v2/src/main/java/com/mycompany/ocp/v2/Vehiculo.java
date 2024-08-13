/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
abstract class Vehiculo {
    protected final String placa;
    protected final int valorMercado;
    protected final String color;
    protected final int año;
    protected final String marca;

    public Vehiculo(String placa, int valorMercado, String color, int año, String marca) {
        this.placa = placa;
        this.valorMercado = valorMercado;
        this.color = color;
        this.año = año;
        this.marca = marca;
    }
    
    public void encender(){
    System.out.println("Automovil encendido");
    }   

    String getPlaca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getValorMercado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
