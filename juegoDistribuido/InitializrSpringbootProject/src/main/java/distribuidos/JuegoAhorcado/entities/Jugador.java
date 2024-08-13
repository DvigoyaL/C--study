package distribuidos.JuegoAhorcado.entities;

import org.springframework.stereotype.Component;

@Component
public class Jugador {
    private String nombre;
    private int turno;
    private int intentos;
    private StringBuilder progreso;

    public Jugador() {
        this.intentos = 5;
    }

    public StringBuilder getProgreso() {
        return progreso;
    }

    public void setProgreso(StringBuilder progreso) {
        this.progreso = progreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", turno=" + turno + ", intentos=" + intentos + ", progreso=" + progreso + '}';
    }
    
    
}
