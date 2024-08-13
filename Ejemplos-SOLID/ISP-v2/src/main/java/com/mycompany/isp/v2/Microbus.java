/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public class Microbus extends VehiculoMayorACuatroRuedas {

    public Microbus(int numeroPasajeros, String placa, int valorMercado, String color, int año, String marca) {
        super(numeroPasajeros, placa, valorMercado, color, año, marca);
    }

    public void imprimirInformacion() {
        System.out.println("Bus marca " + marca + ", cantidad maxima pasajeros " + numeroPasajeros );
    }

    @Override
    public String toString() {
        return "Bus{" + "placa=" + placa + ", marca=" + marca + ", cantidad maxima pasajeros=" + numeroPasajeros + '}';
    }

    @Override
    public void pagarPeaje() {
        System.out.println("Tarifa de pejae a pagar por Bus: $28000");
    }

    @Override
    public void subirPasajero() {
        System.out.println("Subiendo pasajeros");
    }

    @Override
    public void bajarPasajero() {
        System.out.println("Bajando pasajeros");
    }

    @Override
    public void anunciarParada() {
        System.out.println("El servicio de mricrobus es puerta a puerta");
    }
}
