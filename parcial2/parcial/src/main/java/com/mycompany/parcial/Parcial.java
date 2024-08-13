package com.mycompany.parcial;

import java.sql.SQLException;
import java.util.List;
import com.mycompany.parcial.dao.*;
import com.mycompany.parcial.operaciones.IDate;
import com.mycompany.parcial.operaciones.dateMysql;
import com.mycompany.parcial.operaciones.datePgSQL;
import com.mycompany.parcial.operaciones.diferencia;
import com.mycompany.parcial.operaciones.union;
import dominio.*;
import java.util.HashSet;
import java.util.Set;

public class Parcial {

    public static void main(String[] args) {
        //Creamos los nuevos productos a registrar
        Clientes cliente1 = new Clientes("Juan", "Pérez", "contraseña123");
        Clientes cliente2 = new Clientes("María", "Gómez", "clave456");
        Direccion direccion1 = new Direccion(1, "País1", "Dirección1", 12345);
        Direccion direccion2 = new Direccion(2, "País2", "Dirección2", 67890);
        Producto producto1 = new Producto("Laptop", 1200.0, 50);
        Producto producto2 = new Producto("Smartphone", 500.0, 100);
        Envio envio1 = new Envio(1, 1, 3);
        Envio envio2 = new Envio(2, 2, 4);

        //Creation of the DAO instance  
        ClienteDAO clienteDAO = new ClienteDAO();
        DireccionDAO direccionDAO = new DireccionDAO();
        ProductoDAO productoDAO = new ProductoDAO();
        EnvioDAO envioDAO = new EnvioDAO();
        union union = new union();
        diferencia diferencia = new diferencia();
        diferencia.diferencia();
        union.union();
        IDate fechaMy = new dateMysql();
        //IDate fechaPg = new datePgSQL();
        System.out.println(fechaMy.getDate());
        //System.out.println(fechaPg.getDate());
        //Product persist  
        /*clienteDAO.saveCliente(cliente1);
        clienteDAO.saveCliente(cliente2);
        direccionDAO.guardarDireccion(direccion1);
        direccionDAO.guardarDireccion(direccion2);
        productoDAO.saveProducto(producto1);
        productoDAO.saveProducto(producto2);
        envioDAO.saveEnvio(envio1);
        envioDAO.saveEnvio(envio2);*/
        //Create the products  
        //clienteDAO.eliminarCliente(2);
        /*List<Clientes> clientes = clienteDAO.buscarTodosClientes();
        System.out.println("Clientes size ==> " + clientes.size());
        for (Clientes cliente : clientes) {
            System.out.println(cliente);
        }
        List<Direccion> direcciones = direccionDAO.listarTodasDirecciones();
        System.out.println("Direcciones size ==> " + direcciones.size());
        for (Direccion direccion : direcciones) {
            System.out.println(direccion);*/
    }
}