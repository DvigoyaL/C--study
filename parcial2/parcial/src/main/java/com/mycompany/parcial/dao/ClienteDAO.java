package com.mycompany.parcial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import dominio.Clientes;
import java.sql.SQLException;

public class ClienteDAO {

    private DBAdaptador dbAdaptador;

    public ClienteDAO() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    public List<Clientes> buscarTodosClientes() {
        Connection conexion = dbAdaptador.getConnection();
        List<Clientes> listaClientes = new ArrayList<>();
        try {
            PreparedStatement statment = conexion.prepareStatement("SELECT id, nombre, apellido, password FROM clientes;");
            ResultSet resultado = statment.executeQuery();
            while (resultado.next()) {
                listaClientes.add(new Clientes(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4)));
            }
            return listaClientes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
            }
        }
    }

    public boolean saveCliente(Clientes cliente) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("INSERT INTO clientes (nombre, apellido, password) VALUES (?, ?, ?)")) {
                statement.setString(1, cliente.getNombre());
                statement.setString(2, cliente.getApellido());
                statement.setString(3, cliente.getContraseña());
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

    public boolean eliminarCliente(int idCliente) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("DELETE FROM clientes WHERE id = ?")) {
                statement.setInt(1, idCliente);
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

    public boolean actualizarCliente(Clientes cliente) {
        Connection conexion = dbAdaptador.getConnection();

        try {
            conexion.setAutoCommit(false);  // Deshabilitar el modo de confirmación automática

            try ( PreparedStatement statement = conexion.prepareStatement("UPDATE clientes SET nombre = ?, apellido = ?, password = ? WHERE id = ?")) {
                statement.setString(1, cliente.getNombre());
                statement.setString(2, cliente.getApellido());
                statement.setString(3, cliente.getContraseña());
                statement.setInt(4, cliente.getId());

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
}
