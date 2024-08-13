package dominio;

public class Direccion {

    private int idAdress;
    private int fk_cliente;
    private String pais;
    private String direccion;
    private int zipCode;

    public Direccion(int cliente, String pais, String direccion, int zipCode) {
        this.fk_cliente = cliente;
        this.pais = pais;
        this.direccion = direccion;
        this.zipCode = zipCode;
    }

    public Direccion() {
        this.fk_cliente = 0;
        this.pais = null;
        this.direccion = null;
        this.zipCode = 0;
    }

    public int getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(int idAdress) {
        this.idAdress = idAdress;
    }

    public int getFk_cliente() {
        return fk_cliente;
    }

    public void setFk_cliente(int fk_cliente) {
        this.fk_cliente = fk_cliente;
    }

    

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Direccion{" + "idAdress=" + idAdress + ", fk_cliente=" + fk_cliente + ", pais=" + pais + ", direccion=" + direccion + ", zipCode=" + zipCode + '}';
    }

    
}
