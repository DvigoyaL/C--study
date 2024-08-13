package dominio;

public class Envio {

    private int idEnvio;
    private Clientes cliente;
    private Producto producto;
    private Direccion direccion;
    private int id_cliente;
    private int id_producto;
    private int id_direccion;

    public Envio(Clientes cliente, Producto producto, Direccion direccion) {
        this.cliente = cliente;
        this.producto = producto;
        this.direccion = direccion;
    }

    public Envio(int id_cliente, int id_producto, int id_direccion) {
        this.id_cliente = id_cliente;
        this.id_producto = id_producto;
        this.id_direccion = id_direccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    
    
    public int getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(int idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
