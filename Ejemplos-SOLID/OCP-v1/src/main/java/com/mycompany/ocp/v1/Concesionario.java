/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ocp.v1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Concesionario {
   private List<Automovil> Inventario;
   private String nombre;

    public Concesionario(String nombre) {
        Inventario = new ArrayList<>();
        this.nombre = nombre;
    } 
   public void generarInventario(){
        Inventario.add(new Automovil("ABC123", "Sedán", "Rojo", 2019, "Toyota", 15000));
        Inventario.add(new Automovil("XYZ789", "Camioneta", "Azul", 2018, "Honda", 18000));
        Inventario.add(new Automovil("LMN456", "Deportivo", "Negro", 2020, "Ford", 20000));
        Inventario.add(new Automovil("PQR321", "SUV", "Blanco", 2017, "Chevrolet", 16000));
   }
   public void comprarAutomovil(Automovil carroParaComprar){
       System.out.println("Se ha comprado el automovil de placa " + carroParaComprar.getPlaca());
       Inventario.add(carroParaComprar);
   }
   public void venderAutomovil(){
       if(Inventario.isEmpty()){
           System.out.println("No hay carros disponibles para venta");
       }else {
           System.out.println("Se ha vendido el automovil de placa " + Inventario.get(0).getPlaca() + " en " + Inventario.get(0).getValorMercado());
           Inventario.remove(Inventario.get(0));
       }
   }
   public void MostrarAutomovil(){
       for (int i = 0; i < Inventario.size(); i++) {
           System.out.println(Inventario.get(i));
       }
   }   

    public List<Automovil> getInventario() {
        return Inventario;
    }
   
}
