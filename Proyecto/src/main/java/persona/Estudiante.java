/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante_MCA
 */
public class Estudiante extends Persona{
    private final int numero_est;
    private final List<String> cursosInscritos;
    private List<Float> calificaciones;

        public Estudiante(int numero_est, String nombre, int numero_id, String fecha_nacimiento) {
            super(nombre,numero_id,fecha_nacimiento);
            this.numero_est = numero_est;
            this.cursosInscritos = new ArrayList<>();
            this.calificaciones = new ArrayList<>();
        }
        
        public void inscribirCurso(String curso) {
            cursosInscritos.add(curso);
            System.out.println(nombre + " se ha inscrito en el curso: " + curso);
        }

        public void estudiar() {
            System.out.println(nombre + " esta estudiando los siguientes cursos:");
            for (String curso : cursosInscritos) {
                System.out.println("- " + curso);
            }
        }
        
        public void registrarCalificacion(Float calificacion){
            calificaciones.add(calificacion);
            //System.out.println(nombre + " se ha registrado la calificacion: " + calificacion);
        }
        
        public List<Float> getCalificaciones() {
            return calificaciones;
        }
        
        public boolean insertarEstudiante(Connection con) {
        if (insertarPersona(con)) {
            try {
                String sql = "INSERT INTO estudiantes (id, numero_est) VALUES (?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, numero_id);        
                preparedStatement.setInt(2, numero_est);

                int filasAfectadas = preparedStatement.executeUpdate();

                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }
        
        @Override
        public String toString() {
            return "Estudiante{" + "numero_est=" + numero_est + ", nombre=" + nombre + '}';
        }
}