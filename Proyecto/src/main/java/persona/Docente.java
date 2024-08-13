/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Estudiante_MCA
 */
public class Docente extends Persona{
    private String titulo;
    private String facultad;

        public Docente(String titulo, String facultad, String nombre, int numero_id, String fecha_nacimiento) {
            super(nombre, numero_id, fecha_nacimiento);
            this.titulo = titulo;
            this.facultad = facultad;
        }
        
        public void impartirClase(String curso) {
            System.out.println(nombre + " esta impartiendo la clase de " + curso);
        }

        public void evaluarEstudiante(Estudiante estudiante, Float calificacion) {
            System.out.println(nombre + " esta evaluando al estudiante " + estudiante.nombre);
            estudiante.registrarCalificacion(calificacion);
            System.out.println("Calificacion registrada: " + calificacion);
        }
        
        public Float calcular_promedio(List<Float> notas){
            Float promedio;
            promedio = 0f;
            for (Float nota: notas){
                promedio += nota;
            }
            promedio = promedio/notas.size();
            return promedio;
        }
       public boolean insertarDocente(Connection con) {
        if (insertarPersona(con)) {
            try {
                String sql = "INSERT INTO docentes (id, titulo, facultad) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, numero_id);        
                preparedStatement.setString(2, titulo);
                preparedStatement.setString(3, facultad);

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
        
        public void entregarPromedio(Estudiante estudiante){
            System.out.println("La nota final del estudiante " + estudiante.nombre + " es " + calcular_promedio(estudiante.getCalificaciones()));
        }
    
        @Override
        public String toString() {
            return "Docente{" + "nombre=" + nombre + ", titulo=" + titulo + ", facultad=" + facultad + '}';
        }
}
