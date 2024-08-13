package com.mycompany.parcial;

import com.mycompany.parcial.implementacion.MySqlAdaptador;
import com.mycompany.parcial.implementacion.PgAdaptador;
import Properties.PropertiesUsar;
import java.lang.reflect.Method;
import java.util.Properties;

public class DBfactory {

    private static final String DB_FACTORY_PROPERTY_URL = "C:\\Users\\Usuario\\Proyectos_netbeans\\Java_aplicaciones\\parcial\\src\\main\\java\\configuracion\\DBInicio.properties";
    private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";

    private static DBfactory instancia;
    
    private DBfactory() {
        // Constructor privado para evitar la creación de instancias externas
    }

    public static synchronized DBfactory getInstance() {
        if (instancia == null) {
            instancia = new DBfactory();
        }
        return instancia;
    }

    public DBAdaptador getDefaulAdaptador() {
    try {
        Properties prop = PropertiesUsar.cargarProperty(DB_FACTORY_PROPERTY_URL);
        String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
        System.out.println("DefaultDBClass ==> " + defaultDBClass);

        // Obtenemos la clase mediante reflexión
        Class<?> dbClass = Class.forName(defaultDBClass);

        // Obtenemos el método estático obtenerInstancia si existe
        Method obtenerInstanciaMethod = dbClass.getMethod("obtenerInstancia");

        // Invocamos el método estático para obtener la instancia única
        return (DBAdaptador) obtenerInstanciaMethod.invoke(null);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}

}