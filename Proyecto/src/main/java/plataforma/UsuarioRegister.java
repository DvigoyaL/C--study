/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataforma;

import PersistenciaDatos.PersistenciaDatos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante_MCA
 */
public class UsuarioRegister {

    private PersistenciaDatos<Usuario> persistenciaUsuarios;
    private List<Usuario> listaUsuarios;

    public UsuarioRegister() {
        persistenciaUsuarios = new PersistenciaDatos<>("Archivos/usuarios.txt");
        listaUsuarios = new ArrayList<>();

        try {
            List<Usuario> usuariosCargados = persistenciaUsuarios.cargarObjetos();
            if (usuariosCargados != null) {
                listaUsuarios.addAll(usuariosCargados);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean registrarUsuario(String nombreUsuario, String contrasena) {

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                System.out.println("El nombre de usuario ya existe. Registro fallido.");
                return false;
            }
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasena);
        listaUsuarios.add(nuevoUsuario);

        try {
            persistenciaUsuarios.guardarObjetos(listaUsuarios);
            System.out.println("Registro exitoso.");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void insertarRegistro(Connection conexion, String nombreUsuario, int plataforma, boolean estado) throws SQLException {
        String sql = "INSERT INTO Register (nombreUsuario, plataforma, estado) VALUES (?, ?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setInt(2, plataforma);
            statement.setBoolean(3, estado);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
