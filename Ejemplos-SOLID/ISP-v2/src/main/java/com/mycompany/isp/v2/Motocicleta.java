/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public class Motocicleta extends VehiculoDosRuedas{
    private String tipoMoto;

    public Motocicleta(String tipoMoto, String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        this.tipoMoto = tipoMoto;
    }
    @Override
    public String toString() {
        return "Motocicleta{" + "placa=" + placa + ", tipo de moto=" + tipoMoto + ", marca=" + marca + ", valor en el mercado=" + valorMercado +'}';
    }
    @Override
    public void usarCaballete() {
        System.out.println("La moto está en el caballete");
    }

    @Override
    public void manejoEnTrafico() {
        System.out.println("Avanzando sobre el trafico en momento de trancon");
    }
    
}
