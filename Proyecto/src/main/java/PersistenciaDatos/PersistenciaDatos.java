/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PersistenciaDatos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PersistenciaDatos<T> {
    private String nombreArchivo;

    public PersistenciaDatos(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
    
    public void guardarObjeto(T objeto) throws IOException{
        try(ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(nombreArchivo,true))){
            escribir.writeObject(objeto);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void guardarObjetos(List<T> objetos) throws IOException {
    try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(nombreArchivo, true))) {
        for (T objeto : objetos) {
            escribir.writeObject(objeto);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public List<T> cargarObjetos() throws FileNotFoundException, IOException{
        List<T> objetos = new ArrayList<>();
        try(ObjectInputStream leer = new ObjectInputStream(new FileInputStream(nombreArchivo))){
            while(true){
                try{
                    T objeto = (T) leer.readObject();
                    objetos.add(objeto);
                }catch (EOFException e){
                    break;
                }
            } 
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return objetos;
    }
}
