/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public abstract class VehiculoCuatroRuedas extends VehiculoCuatroRuedasOMayor {

    protected final int numeroPuertas;
    protected final String tipoCombustible;

    public VehiculoCuatroRuedas(int numeroPuertas, String tipoCombustible, String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
        this.numeroPuertas = numeroPuertas;
        this.tipoCombustible = tipoCombustible;
    }

    public abstract void cargarMercancia();

    public abstract void descargarMercancia();
}
