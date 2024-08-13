/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.isp.v1;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Usuario
 */
public class Concesionario {
   private List<Vehiculo> Inventario;
   private String nombre;

    public Concesionario(String nombre) {
        Inventario = new ArrayList<>();
        this.nombre = nombre;
    } 
   public void generarInventario(){
        Inventario.add(new Automovil("Sedán", 4, "Gasolina", "ABC123", 25000, "Rojo", 2022, "Toyota"));
        Inventario.add(new Automovil("Camioneta", 5, "Diésel", "XYZ789", 35000, "Azul", 2021, "Ford"));
        Inventario.add(new Motocicleta("Cruiser", "XYZ789", 18000, "Blanco", 2021, "Harley-Davidson"));
        Inventario.add(new Motocicleta("Deportiva", "ABC456", 15000, "Negro", 2022, "Honda"));
        Inventario.add(new Bus(60, 1, 3, "Gasolina", "XYZ789", 120000, "Rojo", 2021, "Volvo"));
        Inventario.add(new Bus(40, 2, 2, "Diésel", "ABC123", 100000, "Azul", 2022, "Mercedes"));
        
        
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
   public void MostrarInventario(){
       System.out.println("                 Max - Autos");
       System.out.println("A continuacion se muestran los vehiculos disponibles:");
       for (int i = 0; i < Inventario.size(); i++) {
           System.out.println(Inventario.get(i));
       }
   }   

    public List<Vehiculo> getInventario() {
        return Inventario;
    }
   
}
