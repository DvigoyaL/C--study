/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public class Bus extends Vehiculo {

    private int numeroPasajeros;
    private int cantidadPisos;

    public Bus(int numeroPasajeros, int cantidadPisos, String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        this.numeroPasajeros = numeroPasajeros;
        this.cantidadPisos = cantidadPisos;
    }

    public void imprimirInformacion() {
        System.out.println("Bus marca " + marca + ", cantidad maxima pasajeros " + numeroPasajeros + " repartidos en " + cantidadPisos + " piso");
    }

    @Override
    public String toString() {
        return "Bus{" + "placa=" + placa + ", marca=" + marca + ", cantidad maxima pasajeros=" + numeroPasajeros + '}';
    }

    @Override
    public void pagarPeaje() {
        System.out.println("Tarifa de pejae a pagar por Bus: $32000");
    }

    @Override
    public void encenderLimpiaParabrisas() {
        System.out.println("Limpiaparabrisas encendido");
    }

    @Override
    public void abrirCapo() {
        System.out.println("Capo abierto");
    }

    @Override
    public void usarCaballete() {
        System.out.println("Un bus no tiene caballete");
    }
    
}
