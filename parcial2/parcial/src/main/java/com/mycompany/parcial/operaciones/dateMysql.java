package com.mycompany.parcial.operaciones;

import com.mycompany.parcial.DBAdaptador;
import com.mycompany.parcial.DBfactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateMysql implements IDate {
    private DBAdaptador dbAdaptador;

    public dateMysql() {
        dbAdaptador = DBfactory.getInstance().getDefaulAdaptador();
    }

    @Override
    public String getDate() {
        try (Connection connection = dbAdaptador.getConnection()) {
            String query = "SELECT NOW() as current_datetime"; // Consulta SQL para obtener la fecha y hora actual
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    Date currentDatetime = resultSet.getTimestamp("current_datetime");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    return dateFormat.format(currentDatetime);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
