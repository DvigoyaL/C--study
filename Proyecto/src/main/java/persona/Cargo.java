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
public class Cargo {

    private int numero_cargo;
    private String descrip_cargo;

    public Cargo(int numero_cargo, String descrip_cargo) {
        this.numero_cargo = numero_cargo;
        this.descrip_cargo = descrip_cargo;
    }

    public int getNumero_cargo() {
        return numero_cargo;
    }

    public void setNumero_cargo(int numero_cargo) {
        this.numero_cargo = numero_cargo;
    }

    public String getDescrip_cargo() {
        return descrip_cargo;
    }

    public void setDescrip_cargo(String descrip_cargo) {
        this.descrip_cargo = descrip_cargo;
    }

    public void insertarCargo(Connection conexion) throws SQLException {
        String sql = "INSERT INTO cargos (id, descrip_cargo) VALUES (?, ?)";
        try ( PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, numero_cargo);
            statement.setString(2, descrip_cargo);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Cargo{" + "numero_cargo=" + numero_cargo + ", descrip_cargo=" + descrip_cargo + '}';
    }
}
