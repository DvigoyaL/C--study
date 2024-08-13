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
public class Empresa {

    private String razon_social;
    private int nit;
    private String descripcion;
    private List<PersonaCargo> empleados;

    public Empresa(String razon_social, int nit, String descripcion) {
        this.razon_social = razon_social;
        this.nit = nit;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(PersonaCargo empleado) {
        empleados.add(empleado);
        System.out.println("Empleado " + empleado.getPersona().nombre + " ha sido contratado a la empresa " + razon_social);
    }

    public void eliminarEmpleado(PersonaCargo empleado) {
        empleados.remove(empleado);
        System.out.println("Empleado " + empleado.getPersona().nombre + " ha sido despedido de la empresa " + razon_social);
    }

    public List<PersonaCargo> getEmpleados() {
        return empleados;
    }

    public void mostrarInformacionEmpresa() {
        System.out.println("Nombre de la Empresa: " + razon_social);
        System.out.println("Nit: " + nit);
        System.out.println("Número de Empleados: " + empleados.size());
    }

    public void mostrarEmpleados() {
        System.out.println("Lista de Empleados en " + razon_social + ":");
        for (PersonaCargo empleado : empleados) {
            System.out.println("Nombre: " + empleado.getPersona().nombre);
            System.out.println("Cargo: " + empleado.getCargo().getDescrip_cargo());
            System.out.println("--------------------");
        }
    }

    public int getNit() {
        return nit;
    }
    
    public void insertarEmpresas(Connection conexion) throws SQLException {
        String sql = "INSERT INTO empresas (nit, razon_social, descrip) VALUES (?, ?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, nit);
            statement.setString(2, razon_social);
            statement.setString(3, descripcion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Empresa{" + "razon_social=" + razon_social + ", nit=" + nit + ", descripcion=" + descripcion + '}';
    }

}
