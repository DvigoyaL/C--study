package com.mycompany.parcial.operaciones;

import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class datePgSQL implements IDate {

    private DBAdaptador dbAdaptador;

    public datePgSQL() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    @Override
    public String getDate() {
        try ( Connection connection = dbAdaptador.getConnection()) {
            String query = "SELECT current_timestamp";
            try ( PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // La columna 1 contiene la fecha y hora actual
                        return resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
