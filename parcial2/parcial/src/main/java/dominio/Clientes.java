package dominio;

public class Clientes {

    private int id;
    private String nombre;
    private String apellido;
    private String password;

    public Clientes(String nombre, String apellido, String Contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = Contraseña;
    }
    
    public Clientes(int id, String nombre, String apellido, String Contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = Contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String Contraseña) {
        this.password = Contraseña;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
    
}
