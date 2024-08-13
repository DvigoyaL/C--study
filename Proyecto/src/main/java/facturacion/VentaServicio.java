/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import persona.Persona;

/**
 *
 * @author juan9
 */
public class VentaServicio {

    private Persona persona;
    private DetalleVentaServicio detalleventaservicio;
    private int numeroVenta;
    private String fechaVenta;

    public VentaServicio(Persona persona, DetalleVentaServicio detalleventaservicio, int numeroVenta, String fechaVenta) {
        this.persona = persona;
        this.detalleventaservicio = detalleventaservicio;
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "VentaServicio{" + "persona=" + persona + ", detalleventaservicio=" + detalleventaservicio + ", numeroVenta=" + numeroVenta + ", fechaVenta=" + fechaVenta + '}';
    }

    public Persona getPersona() {
        return persona;
    }

    public DetalleVentaServicio getDetalleVentaServicio() {
        return detalleventaservicio;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int calcularMontoTotal() {
        return detalleventaservicio.calcularSubtotal();
    }

    public void mostrarInformacionDetallada() {
        System.out.println("Número de Venta: " + numeroVenta);
        System.out.println("Fecha de Venta: " + fechaVenta);
        System.out.println("Datos de la Persona:");
        persona.toString(); // Suponiendo que la clase Persona tenga un método similar
        System.out.println("Detalles de Venta:");
        detalleventaservicio.mostrarInformacionDetallada(); // Suponiendo que la clase DetalleVentaServicio tenga un método similar
        System.out.println("Monto Total: " + calcularMontoTotal());
    }

}
