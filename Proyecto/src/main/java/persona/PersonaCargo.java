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
public class PersonaCargo {
    private int id;
    private Persona persona;
    private Cargo cargo;
    private Empresa empresa;

    public PersonaCargo(int id, Persona persona, Cargo cargo, Empresa empresa) {
        this.id=id;
        this.persona = persona;
        this.cargo = cargo;
        this.empresa = empresa;
    }

    public void aumentarSalario(Empleado empleado, double porcentajeAumento) {
        double salario = empleado.getSalario() * (1 + porcentajeAumento);
        empleado.setSalario(salario);
        System.out.println(empleado.nombre + " ha recibido un aumento salarial del " + (porcentajeAumento * 100) + "%" + " salario nuevo: " + empleado.getSalario());
    }

    public Persona getPersona() {
        return persona;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void insertarCargo(Connection conexion) throws SQLException {
        String sql = "INSERT INTO personaCargo (id, persona_id, cargo_id, empresa_id) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            conexion.setAutoCommit(false);
            statement.setInt(1, id);
            statement.setInt(2, persona.numero_id);
            statement.setInt(3, cargo.getNumero_cargo());
            statement.setInt(4, empresa.getNit());
            statement.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            conexion.rollback();
            e.printStackTrace();
        }
        finally{
            conexion.setAutoCommit(true);
        }
    }

    @Override
    public String toString() {
        return "PersonaCargo{" + "persona=" + persona + ", cargo=" + cargo + ", empresa=" + empresa + '}';
    }
}
