/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataforma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Estudiante_MCA
 */
public class Usuario {

    String nombre;
    String password;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    public String toString() {
        return nombre + " " + password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void insertarUsuario(Connection conexion, String nombre, String password) throws SQLException {
        String sql = "INSERT INTO Usuario (nombre, password) VALUES (?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombre);
            statement.setString(2, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarUsuario(Connection conexion, String nombre) throws SQLException {
    String sql = "DELETE FROM Usuario WHERE nombre = ?";
    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
        statement.setString(1, nombre);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}

