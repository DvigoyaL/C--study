/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public class Camioneta extends VehiculoCuatroRuedas {

    private String traccion;

    public Camioneta(String traccion, int numeroPuertas, String tipoCombustible, String placa, int valorMercado, String color, int año, String marca) {
        super(numeroPuertas, tipoCombustible, placa, valorMercado, color, año, marca);
        this.traccion = traccion;
    }

    public void imprimirInformacion() {
        System.out.println("Camioneta " + traccion + ", marca " + marca + ", color " + color + " avaluado en $" + valorMercado);
    }

    @Override
    public String toString() {
        return "Automovil{" + "placa=" + placa + ", traccion=" + traccion + ", marca=" + marca + ", color=" + color + ", valor en el mercado=$" + valorMercado + '}';
    }

    @Override
    public void pagarPeaje() {
        System.out.println("Tarifa de pejae a pagar por automovil: $20000");
    }

    @Override
    public void cargarMercancia() {
        System.out.println("Cargando mercancia");
    }

    @Override
    public void descargarMercancia() {
        System.out.println("Bajando mercancia");
    }

}
