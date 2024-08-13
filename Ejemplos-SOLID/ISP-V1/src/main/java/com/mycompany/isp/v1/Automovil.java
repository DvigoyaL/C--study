/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v1;

/**
 *
 * @author Usuario
 */
public class Automovil extends VehiculoCuatroRuedasOMayor {
    private String tipoAutomovil;

    public Automovil(String tipoAutomovil, int numeroPuertas, String tipoCombustible, String placa, int valorMercado, String color, int año, String marca) {
        super(numeroPuertas, tipoCombustible, placa, valorMercado, color, año, marca);
        this.tipoAutomovil = tipoAutomovil;
    }
    
    public void imprimirInformacion(){
        System.out.println("Automovil tipo " + tipoAutomovil + ", marca " + marca + ", color " + color + " avaluado en $" + valorMercado);
    }
    @Override
    public String toString() {
        return "Automovil{" + "placa=" + placa + ", tipo=" + tipoAutomovil + ", marca=" + marca + ", color=" + color + ", valor en el mercado=$" + valorMercado + '}';
    }
    @Override
    public void pagarPeaje() {
        System.out.println("Tarifa de pejae a pagar por automovil: $12000");
    }

    @Override
    public void cargarMercancia() {
        System.out.println("El automovil no tiene espacio para cargar mercancia");    }

    @Override
    public void descargarMercancia() {
        System.out.println("El automovil no tiene espacio para cargar mercancia");
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
        System.out.println("El automovil no cuenta con paradas");  
    }
    
}
