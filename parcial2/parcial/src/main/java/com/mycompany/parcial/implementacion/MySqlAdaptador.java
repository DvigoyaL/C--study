package com.mycompany.parcial.implementacion;

import com.mycompany.parcial.DBAdaptador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import Properties.PropertiesUsar;

public class MySqlAdaptador implements DBAdaptador {

    private static final String DB_CONFIG_PATH = "C:\\Users\\Usuario\\Proyectos_netbeans\\Java_aplicaciones\\parcial\\src\\main\\java\\configuracion\\DBMySQL.properties";
    private static final String DB_NAME_PROP = "dbname";
    private static final String HOST_PROP = "host";
    private static final String PASSWORD_PROP = "password";
    private static final String PORT_PROP = "port";
    private static final String USER_PROP = "user";

    private static MySqlAdaptador instancia;

    // Constructor privado para evitar instanciación externa
    private MySqlAdaptador() {
    }

    // Método estático para obtener la instancia única
    public static synchronized MySqlAdaptador obtenerInstancia() {
        if (instancia == null) {
            instancia = new MySqlAdaptador();
        }
        return instancia;
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUsar.cargarProperty(DB_CONFIG_PATH);
        String host = prop.getProperty(HOST_PROP);
        String port = prop.getProperty(PORT_PROP);
        String db = prop.getProperty(DB_NAME_PROP);
        String user = prop.getProperty(USER_PROP);
        String password = prop.getProperty(PASSWORD_PROP);

        String connectionString = "jdbc:mysql://" + host
                + ":" + port + "/" + db + "?user=" + user + "&password=" + password;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }
}
