/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facturacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juan9
 */
public class Facturacion {

    private VentaServicio ventaservicio;
    private int numeroFactura;
    private String fechaEmision;

    public Facturacion(VentaServicio ventaservicio, int numeroFactura, String fechaEmision) {
        this.ventaservicio = ventaservicio;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "Facturacion{" + "ventaservicio=" + ventaservicio + ", numeroFactura=" + numeroFactura + ", fechaEmision=" + fechaEmision + '}';
    }

    public VentaServicio getVentaServicio() {
        return ventaservicio;
    }

    public void setVentaServicio(VentaServicio ventaservicio) {
        this.ventaservicio = ventaservicio;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int calcularTotalFactura() {
        return ventaservicio.calcularMontoTotal();
    }

    public void mostrarInformacionDetallada() {
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha de Emisión: " + fechaEmision);
        System.out.println("Información de la Venta de Servicios:");
        ventaservicio.mostrarInformacionDetallada(); // Suponiendo que la clase VentaServicio tenga un método similar
        System.out.println("Total de la Factura: " + calcularTotalFactura());
    }

}
