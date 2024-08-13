/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public class Bus extends VehiculoMayorACuatroRuedas {

    private int cantidadPisos;

    public Bus(int cantidadPisos, int numeroPasajeros, String placa, int valorMercado, String color, int año, String marca) {
        super(numeroPasajeros, placa, valorMercado, color, año, marca);
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
    public void subirPasajero() {
        System.out.println("Subiendo pasajero");
    }

    @Override
    public void bajarPasajero() {
        System.out.println("Bajando pasajero");
    }

    @Override
    public void anunciarParada() {
        System.out.println("La siguiente parada del bus sera en 5 min...");
    }
}
