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
public class DetalleVentaServicio {

    private Servicios servicios;
    private int cantidad;

    public DetalleVentaServicio(Servicios servicios, int cantidad) {
        this.servicios = servicios;
        this.cantidad = cantidad;

    }

    public void insertarDetalleVenta(Connection conexion) throws SQLException {
        String sql = "INSERT INTO DetalleVentaServicio (servicios_codigoServicio, cantidad) VALUES (?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, servicios.getCodigoServicio());
            statement.setInt(2, cantidad);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DetalleVentaServicio{" + "servicios=" + servicios + ", cantidad=" + cantidad + '}';
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int calcularSubtotal() {
        return servicios.getPrecio() * cantidad;
    }

    public void mostrarInformacionDetallada() {
        System.out.println("Servicio: " + servicios.getNombreServicio());
        System.out.println("Precio unitario: " + servicios.getPrecio());
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Subtotal: " + calcularSubtotal());
    }

}
