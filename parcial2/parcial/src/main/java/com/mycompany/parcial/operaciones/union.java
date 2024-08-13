package com.mycompany.parcial.operaciones;

import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class union {

    private DBAdaptador dbAdaptador;

    public union() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    public static void imprimirTabla(List<Producto> productos) {
        System.out.println("| id |   nombre   | precio | stock |");
        System.out.println("|----|------------|--------|-------|");

        for (Producto producto : productos) {
            System.out.printf("| %-2d | %-10s | %-6.2f | %-5d |\n",
                    producto.getId(), producto.getNombre(), producto.getPrecio(), producto.getStock());
        }
    }

    public List<Producto> union() {
        List<Producto> productos = new ArrayList<>();

        try ( Connection connection = dbAdaptador.getConnection()) {
            connection.setAutoCommit(false);
            String query = "SELECT id, nombre, precio, stock FROM productos\n"
                    + "UNION\n"
                    + "SELECT id, nombre, precio, stock FROM productos2;";

            try ( PreparedStatement preparedStatement = connection.prepareStatement(query);  ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    Producto producto = new Producto();
                    producto.setId(resultSet.getInt("id"));
                    producto.setNombre(resultSet.getString("nombre"));
                    producto.setPrecio(resultSet.getFloat("precio"));
                    producto.setStock(resultSet.getInt("stock"));

                    productos.add(producto);
                }
            } catch (SQLException e) {
                System.err.println("Error al obtener los productos de la base de datos: " + e.getMessage());
            } finally {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    System.err.println("Error al restaurar el autocommit: " + e.getMessage());
                }
            }
            imprimirTabla(productos);
            return productos;
        } catch (SQLException e) {
            System.err.println("Error al obtener la conexión: " + e.getMessage());
            return null;
        }
    }

}
