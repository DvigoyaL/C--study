/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public class Motocicleta extends Vehiculo{
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
    public void pagarPeaje() {
        System.out.println("La moto no paga peaje");
    }

    @Override
    public void encenderLimpiaParabrisas() {
        System.out.println("La moto no tiene limpiaparabrisas");    }

    @Override
    public void abrirCapo() {
        System.out.println("La moto no cuenta con capo");
    }

    
}
