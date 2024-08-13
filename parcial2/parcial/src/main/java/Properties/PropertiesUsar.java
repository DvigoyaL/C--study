package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUsar {

    public static Properties cargarProperty(String propertyPath) {
        try (InputStream inputStream = new FileInputStream(propertyPath)) {
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
