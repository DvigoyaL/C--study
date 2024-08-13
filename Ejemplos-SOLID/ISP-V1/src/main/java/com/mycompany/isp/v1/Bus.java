/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v1;

/**
 *
 * @author Usuario
 */
public class Bus extends VehiculoCuatroRuedasOMayor {

    private int numeroPasajeros;
    private int cantidadPisos;

    public Bus(int numeroPasajeros, int cantidadPisos, int numeroPuertas, String tipoCombustible, String placa, int valorMercado, String color, int año, String marca) {
        super(numeroPuertas, tipoCombustible, placa, valorMercado, color, año, marca);
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
    public void cargarMercancia() {
        System.out.println("El bus no cuenta con espacio para cargar mercancia");
    }

    @Override
    public void descargarMercancia() {
        System.out.println("El bus no cuenta con espacio para cargar mercancia");
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
