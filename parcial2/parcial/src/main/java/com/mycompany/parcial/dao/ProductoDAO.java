package com.mycompany.parcial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import dominio.Producto;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAO {

    private DBAdaptador dbAdaptador;

    public ProductoDAO() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    public List<Producto> buscarTodosProductos() {
        Connection conexion = dbAdaptador.getConnection();
        List<Producto> productos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM productos";
            PreparedStatement statement = conexion.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                int stock = resultSet.getInt("stock");

                Producto producto = new Producto(id, nombre, precio, stock);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return productos;
    }

    public boolean saveProducto(Producto producto) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)")) {
                statement.setString(1, producto.getNombre());
                statement.setDouble(2, producto.getPrecio());
                statement.setInt(3, producto.getStock());
                statement.executeUpdate();

                conexion.commit();  // Confirmar la transacción si todo fue exitoso
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();  // Revertir la transacción en caso de excepción
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean eliminarProducto(int idProducto) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("DELETE FROM productos WHERE id = ?")) {
                statement.setInt(1, idProducto);
                int filasEliminadas = statement.executeUpdate();

                if (filasEliminadas > 0) {
                    conexion.commit();  // Confirmar la transacción si se eliminó al menos una fila
                    return true;
                } else {
                    conexion.rollback();  // Revertir la transacción si no se eliminó ninguna fila
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();  // Revertir la transacción en caso de excepción
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean actualizarProducto(Producto producto) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?")) {
                statement.setString(1, producto.getNombre());
                statement.setDouble(2, producto.getPrecio());
                statement.setInt(3, producto.getStock());
                statement.setInt(4, producto.getId());

                int filasActualizadas = statement.executeUpdate();

                if (filasActualizadas > 0) {
                    conexion.commit();  // Confirmar la transacción si se actualizó al menos una fila
                    return true;
                } else {
                    conexion.rollback();  // Revertir la transacción si no se actualizó ninguna fila
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();  // Revertir la transacción en caso de excepción
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Set<Producto> obtenerProductos(String query) {
        Set<Producto> resultSet = new HashSet<>();

        try ( Connection connection = dbAdaptador.getConnection();  Statement statement = connection.createStatement();  ResultSet rs = statement.executeQuery(query)) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                resultSet.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

}
