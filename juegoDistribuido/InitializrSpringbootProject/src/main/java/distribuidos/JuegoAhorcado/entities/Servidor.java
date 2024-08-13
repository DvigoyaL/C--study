package distribuidos.JuegoAhorcado.entities;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@Component
public class Servidor {

    private List<Jugador> jugadores;
    private Boolean estadoJuego;
    private String palabraSecreta;
    private int turnoActual;
    private Timer temporizador;

    @Autowired
    private BancoPalabras bancoPalabras;

    public Servidor() {
        this.temporizador = new Timer();
        this.estadoJuego = false;
        this.jugadores = new ArrayList<>();
        this.turnoActual = 1;
    }

    @PostConstruct
    public void inicializar() {
        this.palabraSecreta = bancoPalabras.obtenerPalabraAlAzar();
    }

    public void asignarTurnos() {
        // Verificar que haya jugadores para asignar turnos
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para asignar turnos.");
            return;
        }
        // Crear una lista de índices para mezclarla y asignar turnos de manera aleatoria
        List<Integer> indices = new ArrayList<>();
        for (int i = 1; i <= jugadores.size(); i++) {
            indices.add(i);
        }
        // Mezclar la lista de índices para asignar turnos aleatorios
        Collections.shuffle(indices);
        // Asignar turnos a los jugadores sin repeticiones
        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).setTurno(indices.get(i));
        }
        System.out.println("Turnos asignados de manera aleatoria.");
    }

    public void inicializarJugadores() {
        String palabraSecreta = getPalabraSecreta();

        for (Jugador jugador : jugadores) {
            StringBuilder progresoInicial = new StringBuilder();
            for (int i = 0; i < palabraSecreta.length(); i++) {
                progresoInicial.append("_");
            }
            jugador.setProgreso(progresoInicial);
        }
        asignarTurnos();
        System.out.println("Jugadores en el juego: " + jugadores);
    }

    public boolean realizarJugada(String nombre, String entrada) {
        String palabraSecreta = getPalabraSecreta();
        Jugador jugador = getJugador(nombre);

        StringBuilder palabraAdivinada = jugador.getProgreso();

        if (entrada.length() == 1) {
            // Si la entrada es una sola letra
            char letra = entrada.charAt(0);
            boolean letraEncontrada = buscarLetraEnPalabra(letra, palabraSecreta, palabraAdivinada);

            if (!letraEncontrada) {
                disminuirIntentos(jugador);

                if (jugador.getIntentos() == 0) {
                    jugadores.remove(jugador);
                    asignarTurnos();
                    return true;
                }
            }

            jugador.setProgreso(palabraAdivinada);
        } else {
            // Si la entrada es una palabra completa
            if (this.palabraSecreta.equalsIgnoreCase(entrada)) {
                jugador.setProgreso(new StringBuilder(this.palabraSecreta));
                return false;
            } else {
                // Si la palabra es correcta, actualiza el progreso del jugador con la palabra completa
                disminuirIntentos(jugador);

                if (jugador.getIntentos() == 0) {
                    jugadores.remove(jugador);
                    asignarTurnos();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean buscarLetraEnPalabra(char letra, String palabraSecreta, StringBuilder palabraAdivinada) {
        boolean letraEncontrada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraSecreta = palabraSecreta.charAt(i);
            if (letraSecreta == letra) {
                palabraAdivinada.setCharAt(i, letraSecreta);
                letraEncontrada = true;
            }
        }

        return letraEncontrada;
    }

    private void disminuirIntentos(Jugador jugador) {
        int intentosRestantes = jugador.getIntentos();
        jugador.setIntentos(intentosRestantes - 1);
    }

    public void siguienteTurno() {
        if (jugadores.size() > 1) {
            if (turnoActual < jugadores.size()) {
                turnoActual++;
            } else {
                turnoActual = 1;
            }
        }
    }

    public void setPalabraSecreta() {
        this.palabraSecreta = bancoPalabras.obtenerPalabraAlAzar();
    }

    public void detenerTemporizador() {
        temporizador.cancel();
    }

    public void iniciarTemporizador() {
        // Ejemplo: Inicia una tarea cada segundo
        temporizador.scheduleAtFixedRate(new TimerTask() {
            private int segundosRestantes = 20;

            @Override
            public void run() {
                if (segundosRestantes > 0) {
                    System.out.println("Tiempo para esperar nuevos jugadores: " + segundosRestantes + " segundos restantes");
                    segundosRestantes--;
                } else {
                    estadoJuego = true;
                    System.out.println("¡El juego ha comenzado!");
                }
            }
        }, 0, 1000); // Inicia la tarea después de 0 ms y repite cada 1000 ms (1 segundo)
    }
    
    public void reiniciarTemporizador() {
        if (temporizador != null) {
            temporizador.cancel();
        }
        temporizador = new Timer();
    }
    
    public Boolean getEstadoJuego() {
        return estadoJuego;
    }
    
    public void resetJugadores(){
       jugadores.clear();
    }
        
    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setEstadoJuego(Boolean estadoJuego) {
        this.estadoJuego = estadoJuego;
    }

    public Jugador getJugador(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public void agregarJugador(@Autowired Jugador jugador) {
        jugadores.add(jugador);
    }

}
