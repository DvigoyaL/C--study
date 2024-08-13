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
public class Empleado extends Persona {

    private int num_contrato;
    private double salario;

    public Empleado(int num_contrato, double salario, String nombre, int numero_id, String fecha_nacimiento) {
        super(nombre, numero_id, fecha_nacimiento);
        this.num_contrato = num_contrato;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void solicitarAumentoSalario(double porcentajeAumento) {
        System.out.println(nombre + " ha solicitado un aumento del " + (porcentajeAumento) + "% en su salario.");
    }

    public void calcularIngresoAnual() {
        int ingresoAnual = (int) (salario * 12);
        System.out.println("El ingreso anual de " + nombre + " es $" + ingresoAnual);
    }

    public boolean insertarEmpleado(Connection con) {
        if (insertarPersona(con)) {
            try {
                String sql = "INSERT INTO empleados (id, num_contrato, salario) VALUES (?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);

                preparedStatement.setInt(1, numero_id);
                preparedStatement.setInt(2, num_contrato);
                preparedStatement.setDouble(3, salario);

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
        return "Empleado{" + "num_contrato=" + num_contrato + ", salario=" + salario + '}';
    }
}
