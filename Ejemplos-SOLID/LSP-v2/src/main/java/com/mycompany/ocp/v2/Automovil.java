/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v2;

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
    
}
