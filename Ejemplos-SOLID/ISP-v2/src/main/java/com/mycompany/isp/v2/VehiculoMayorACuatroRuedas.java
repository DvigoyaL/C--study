/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public abstract class VehiculoMayorACuatroRuedas extends VehiculoCuatroRuedasOMayor {

    protected int numeroPasajeros;

    public VehiculoMayorACuatroRuedas(int numeroPasajeros, String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        this.numeroPasajeros = numeroPasajeros;
    }

    public abstract void subirPasajero();

    public abstract void bajarPasajero();

    public abstract void anunciarParada();
}
