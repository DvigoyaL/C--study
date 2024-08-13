/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.ocp.v2;

/**
 *
 * @author Usuario
 */
public abstract class VehiculoCuatroRuedasOMayor extends Vehiculo{
    protected int numeroPuertas;
    protected String tipoCombustible;

    public VehiculoCuatroRuedasOMayor(int numeroPuertas, String tipoCombustible, String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
    }
    
    public void encenderLimpiaParabrisas() {
        System.out.println("limpiaParabrisas encendido");
    }
    
    public void abrirCapo() {
        System.out.println("Capo abierto");
    }
    
    public abstract void pagarPeaje();   
}
