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
public class Servicios {

    private int codigoServicio;
    private String nombreServicio;
    private int precio;
    private int duracion;

    public Servicios(int codigoServicio, String nombreServicio, int precio, int duracion) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.duracion = duracion;
    }

    public void insertarServicio(Connection conexion) throws SQLException {
        String sql = "INSERT INTO Servicios (codigoServicio, nombreServicio, precio, duracion) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, codigoServicio);
            statement.setString(2, nombreServicio);
            statement.setInt(3, precio);
            statement.setInt(4, duracion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Servicios{" + "codigoServicio=" + codigoServicio + ", nombreServicio=" + nombreServicio + ", precio=" + precio + ", duracion=" + duracion + '}';
    }

    public int getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarInformacionDetallada() {
        System.out.println("Código de Servicio: " + codigoServicio);
        System.out.println("Nombre de Servicio: " + nombreServicio);
        System.out.println("Precio: " + precio);
        System.out.println("Duración: " + duracion + " minutos");
    }

}
