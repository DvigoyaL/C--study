/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.isp.v2;

/**
 *
 * @author Usuario
 */
public abstract class VehiculoCuatroRuedasOMayor extends Vehiculo {

    public VehiculoCuatroRuedasOMayor(String placa, int valorMercado, String color, int año, String marca) {
        super(placa, valorMercado, color, año, marca);
    }

    public void encenderLimpiaParabrisas() {
        System.out.println("limpiaParabrisas encendido");
    }

    public void abrirCapo() {
        System.out.println("Capo abierto");
    }

    public abstract void pagarPeaje();
}
