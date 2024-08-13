/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srp.ejemplopropio;

/**
 *
 * @author Usuario
 */
public class Automovil {
    private String referencia;
    private String color;
    private int año;
    private String marca;

    public Automovil(String referencia, String color, int año, String marca) {
        this.referencia = referencia;
        this.color = color;
        this.año = año;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Automovil{" + "referencia=" + referencia + ", color=" + color + ", anio=" + año + ", marca=" + marca + '}';
    }
    
public void acelerar(){
    System.out.println("acelerando");
}
public void encender(){
    System.out.println("Automovil encendido");
}
public void detener(){
    System.out.println("Bajando velocidad");
}
public void cambiarMoto(){
    System.out.println("Manejando moto");
}
public void lavar(){
    System.out.println("Lavando el carro");
}
public void checarAceite(){
    System.out.println("revisando nivel de aceite");
}
public void cambiarAceite(){
    System.out.println("cambiando aceite del automovil");
}
}
