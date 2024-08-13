/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataforma;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Estudiante_MCA
 */
public class UsuarioLogin {

    public static boolean Login(ArrayList<Usuario> Lista, Usuario usuario) {
        for (int i = 0; i < Lista.size(); i++) {
            Usuario temp = Lista.get(i);
            System.out.println(temp + "  " + usuario);
            if (temp.toString() == null ? usuario.toString() == null : temp.toString().equals(usuario.toString())) {
                System.out.println("El usuario Si Existe");
                return false;
            }
        }
        System.out.println("El usuario o la contraseña son erroneas vuelva a intentarlo:");
        return true;
    }

    public void insertarLogin(Connection conexion, String nombreUsuario, Date fecha) throws SQLException {
        String sql = "INSERT INTO Login (nombreUsuario, fecha) VALUES (?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, nombreUsuario);
            statement.setDate(2, fecha);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
