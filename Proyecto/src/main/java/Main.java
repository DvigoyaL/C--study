
import static baseDatos.Conexion.getConnection;
import facturacion.DetalleVentaServicio;
import facturacion.Servicios;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persona.Estudiante;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = getConnection();
        /*Persona per1 = new Persona("Juan", 14552452, "1998-02-26");
            per1.insertarPersona(con);*/
        Estudiante est1 = new Estudiante(16040454, "david", 1455232, "2003/01/14");
        est1.insertarEstudiante(con);
            /*System.out.println(est1.toString());
            est1.inscribirCurso("Sociales");
            est1.inscribirCurso("Ingles");
            est1.estudiar();*/
        /*Docente doc1 = new Docente("Licenciatura en matematicas", "Ciencias humanas y de la educacion", "Luis", 145578854, "1995/05/14");
        doc1.insertarDocente(con);
            /*System.out.println(doc1.toString());
            doc1.impartirClase("Sociales");
            doc1.evaluarEstudiante(est1, 4.2f);
            doc1.evaluarEstudiante(est1, 2.1f);
            doc1.calcular_promedio(est1.getCalificaciones());
            doc1.entregarPromedio(est1);
        Empleado emp1 = new Empleado(456654, 1400000, "Cristian", 105467812, "1993/01/11");
        emp1.insertarEmpleado(con);
        /*Empleado emp2 = new Empleado(456654, 1600000, "Camilo", 45567682, "11/08/1983");
        Empleado emp3 = new Empleado(456654, 1200000, "Vanessa", 565378, "31/05/1995");            
        Cargo cargo1 = new Cargo(1, "Profesor");
        Cargo cargo2 = new Cargo(2, "Rector");
        Cargo cargo3 = new Cargo(3, "Secretaria");
        Empresa empresa1 = new Empresa("Unillanos", 145455635, "Universidad de los llanos");
            empresa1.mostrarInformacionEmpresa();
        PersonaCargo perc1 = new PersonaCargo(emp1, cargo1, empresa1);
        PersonaCargo perc2 = new PersonaCargo(emp2, cargo2, empresa1);
        PersonaCargo perc3 = new PersonaCargo(emp2, cargo2, empresa1);
            empresa1.agregarEmpleado(perc3);
            empresa1.agregarEmpleado(perc2);
            empresa1.eliminarEmpleado(perc3);
            empresa1.agregarEmpleado(perc1);
            empresa1.mostrarEmpleados();
            emp3.solicitarAumentoSalario(20);
            perc1.aumentarSalario(emp3, 0.2); 
            emp3.calcularIngresoAnual();*/
        Servicios s = new Servicios(411,"vent",500,12);
        try {
            s.insertarServicio(con);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        DetalleVentaServicio dvs =new DetalleVentaServicio(s,2);
        try {
            dvs.insertarDetalleVenta(con);
            /*Estudiante est1 = new Estudiante(160004001, "Juan", 11111, "21/01/2001");
            VentaServicio vs = new VentaServicio(est1,dvs,2,"2/3/23");
            Facturacion fac = new Facturacion(vs,312,"3/4/23",5);
            System.out.println(s.toString());
            System.out.println(dvs.toString());
            System.out.println(est1.toString());
            System.out.println(vs.toString());
            System.out.println(fac.toString());*/
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
