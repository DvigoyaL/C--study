package com.mycompany.parcial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import dominio.Clientes;
import dominio.Direccion;
import java.sql.SQLException;

public class DireccionDAO {

    private DBAdaptador dbAdaptador;

    public DireccionDAO() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    public List<Direccion> listarTodasDirecciones() {
        List<Direccion> direcciones = new ArrayList<>();
        Connection conexion = dbAdaptador.getConnection();

        try {
            String query = "SELECT idAdress, fk_cliente, pais, direccion, zipCode FROM direccion";
            try ( PreparedStatement statement = conexion.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Direccion direccion = new Direccion();
                    direccion.setIdAdress(resultSet.getInt("idAdress"));
                    direccion.setFk_cliente(resultSet.getInt("fk_cliente"));
                    direccion.setPais(resultSet.getString("pais"));
                    direccion.setDireccion(resultSet.getString("direccion"));
                    direccion.setZipCode(resultSet.getInt("zipCode"));

                    direcciones.add(direccion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return direcciones;
    }

    public boolean guardarDireccion(Direccion direccion) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("INSERT INTO direccion (fk_cliente, pais, direccion, zipCode) VALUES (?, ?, ?, ?)")) {
                statement.setInt(1, direccion.getFk_cliente());
                statement.setString(2, direccion.getPais());
                statement.setString(3, direccion.getDireccion());
                statement.setInt(4, direccion.getZipCode());
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

    public boolean eliminarDireccion(int idDireccion) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("DELETE FROM direccion WHERE idAdress = ?")) {
                statement.setInt(1, idDireccion);
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

}
