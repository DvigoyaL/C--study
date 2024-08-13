/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.srp.v2;

/**
 *
 * @author Usuario
 */
public class Automovil {
    private String placa;
    private String referencia;
    private String color;
    private int año;
    private String marca;

    public Automovil(String placa, String referencia, String color, int año, String marca) {
        this.placa = placa;
        this.referencia = referencia;
        this.color = color;
        this.año = año;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Automovil{" + "placa=" + placa + ", referencia=" + referencia + ", color=" + color + ", anio=" + año + ", marca=" + marca + '}';
    }
    
public void acelerar(){
    System.out.println("acelerando");
}
public void encender(){
    System.out.println("Automovil encendido");
}
public void detener(){
    System.out.println("Bajando velocidad");
}

    public String getReferencia() {
        return referencia;
    }

    public String getColor() {
        return color;
    }

    public String getPlaca() {
        return placa;
    }

}
