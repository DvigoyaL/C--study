/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package plataforma;

import PersistenciaDatos.PersistenciaDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Estudiante_MCA
 */
public class Plataforma {

    private String nombre;
    private String descripcion;

    public Plataforma(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static void agregarPlataforma(Plataforma nuevaPlataforma, PersistenciaDatos<Plataforma> persistenciaPlataformas) throws IOException {
        persistenciaPlataformas.guardarObjeto(nuevaPlataforma);
    }

    public void insertarPlataforma(Connection conexion, int id, String nombre, String descripcion) throws SQLException {
        String sql = "INSERT INTO Plataforma (id, nombre, descripcion) VALUES (?, ?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.setString(2, nombre);
            statement.setString(3, descripcion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPlataforma(Connection conexion, int id) throws SQLException {
        String sql = "DELETE FROM Plataforma WHERE id = ?";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
