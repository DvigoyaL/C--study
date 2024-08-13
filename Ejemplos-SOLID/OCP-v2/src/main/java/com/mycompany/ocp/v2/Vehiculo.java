/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public class Vehiculo {
    protected String placa;
    protected int valorMercado;
    protected String color;
    protected int año;
    protected String marca;

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
    public void encenderLimpiaParabrisas(){};

    public void abrirCapo(){};

    public void pagarPeaje(){};

    public void usarCaballete(){};

    public String getPlaca() {
        return placa;
    }

    public int getValorMercado() {
        return valorMercado;
    }    
    
}
