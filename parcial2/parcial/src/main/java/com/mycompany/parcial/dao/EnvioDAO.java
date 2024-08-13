package com.mycompany.parcial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import dominio.Envio;
import java.sql.SQLException;

public class EnvioDAO {

    private DBAdaptador dbAdaptador;

    public EnvioDAO() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    public boolean saveEnvio(Envio envio) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);

            try ( PreparedStatement statement = conexion.prepareStatement("INSERT INTO envios (id_cliente, id_producto, id_direccion) VALUES (?, ?, ?)")) {
                statement.setInt(1, envio.getId_cliente());
                statement.setInt(2, envio.getId_producto());
                statement.setInt(3, envio.getId_direccion());
                statement.executeUpdate();

                conexion.commit();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();
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

    public boolean eliminarEnvio(int idEnvio) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);

            try ( PreparedStatement statement = conexion.prepareStatement("DELETE FROM envios WHERE id_envio = ?")) {
                statement.setInt(1, idEnvio);
                int filasEliminadas = statement.executeUpdate();

                if (filasEliminadas > 0) {
                    conexion.commit();
                    return true;
                } else {
                    conexion.rollback();
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();
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

    public boolean actualizarEnvio(Envio envio) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);

            try ( PreparedStatement statement = conexion.prepareStatement("UPDATE envios SET id_cliente = ?, id_producto = ?, id_direccion = ? WHERE id_envio = ?")) {
                statement.setInt(1, envio.getCliente().getId());
                statement.setInt(2, envio.getProducto().getId());
                statement.setInt(3, envio.getDireccion().getIdAdress());
                statement.setInt(4, envio.getIdEnvio());

                int filasActualizadas = statement.executeUpdate();

                if (filasActualizadas > 0) {
                    conexion.commit();
                    return true;
                } else {
                    conexion.rollback();
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                conexion.rollback();
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
