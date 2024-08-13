/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Estudiante_MCA
 */
public class Persona{
    protected String nombre;
    protected int numero_id;
    protected String fecha_nacimiento;

        public Persona(String nombre, int numero_id, String fecha_nacimiento) {
            this.nombre = nombre;
            this.numero_id = numero_id;
            this.fecha_nacimiento = fecha_nacimiento;
        }
        public boolean insertarPersona(Connection con) {
        try {
            con.setAutoCommit(false);
            String sql = "INSERT INTO personas (id, nombre, fecha_nacimiento) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(1, numero_id);
            preparedStatement.setString(3, fecha_nacimiento);

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            }
        }
        
        @Override
            public String toString() {
                return "Persona{" + "nombre=" + nombre + ", numero_id=" + numero_id + ", fecha_nacimiento=" + fecha_nacimiento + '}';
            }
        
}
