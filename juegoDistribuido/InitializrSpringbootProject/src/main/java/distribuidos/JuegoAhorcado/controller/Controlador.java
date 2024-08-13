package distribuidos.JuegoAhorcado.controller;

import distribuidos.JuegoAhorcado.entities.BancoPalabras;
import distribuidos.JuegoAhorcado.entities.Jugador;
import distribuidos.JuegoAhorcado.entities.Servidor;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    private Servidor servidor;
    @Autowired
    private Jugador jugador;

    @PostMapping("/empezar_juego")
    public ResponseEntity<String> ingreso() {
        if (servidor.getEstadoJuego()) {
            return new ResponseEntity<>("Error: Ya se inicio el juego.", HttpStatus.BAD_REQUEST);
        }
        servidor.iniciarTemporizador();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        servidor.inicializarJugadores();
        servidor.setPalabraSecreta();
        servidor.reiniciarTemporizador();
        System.out.println("La palabra secreta es: " + servidor.getPalabraSecreta());
        return ResponseEntity.ok("¡Nuevo juego iniciado!");
    }

    @PostMapping("/ingreso")
    public ResponseEntity<String> ingreso(@RequestParam String nombre, @Autowired Jugador nuevoJugador) {
        if (servidor.getEstadoJuego() == true) {
            return new ResponseEntity<>("Error: El juego ya empezo.", HttpStatus.BAD_REQUEST);
        }
        if (servidor.getJugadores().size() > 5) {
            return new ResponseEntity<>("Error: Se permiten hasta 5 jugadores.", HttpStatus.BAD_REQUEST);
        }
        if (servidor.getJugador(nombre) != null) {
            return new ResponseEntity<>("Error: Jugador ya creado.", HttpStatus.BAD_REQUEST);
        }
        if (servidor.getJugadores().size() < 5) {
        servidor.agregarJugador(nuevoJugador);
        }
        return ResponseEntity.ok("¡Jugador agregado: " + nuevoJugador.toString() + "!");
    }

    @GetMapping("/turno_actual")
    public ResponseEntity<String> getTurnoActual() {
        int turnoActual = servidor.getTurnoActual();
        return ResponseEntity.ok("El turno que debe jugar es: " + turnoActual);
    }

    @PostMapping("/jugar")
    public ResponseEntity<String> jugar(@RequestParam String nombre, @RequestParam String letra) {
        if (servidor.getEstadoJuego() == false) {
            return new ResponseEntity<>("Error: El juego no ha empezado.", HttpStatus.BAD_REQUEST);
        }
        if (servidor.getJugador(nombre).getTurno() != servidor.getTurnoActual()) {
            return new ResponseEntity<>("Espera: Todavía no es tu turno." + servidor.getJugador(nombre).toString(), HttpStatus.BAD_REQUEST);
        } else {
            if (servidor.getJugador(nombre).getIntentos() == 0) {
                servidor.siguienteTurno();
                return new ResponseEntity<>("Upps: Te quedaste sin intentos.", HttpStatus.BAD_REQUEST);
            }
            if (servidor.realizarJugada(nombre, letra)) {                
                servidor.siguienteTurno();
                System.out.println(servidor.getTurnoActual());
                return ResponseEntity.ok("Sin intentos, intenta en el proximo juego");
            }            
            servidor.siguienteTurno();
        }
        if (servidor.getPalabraSecreta().equals(servidor.getJugador(nombre).getProgreso().toString())) {
            servidor.setEstadoJuego(false);
            servidor.resetJugadores();
            return ResponseEntity.ok("¡Felicitaciones has ganado!");
        }
        return ResponseEntity.ok("Palabra actualizada: " + servidor.getJugador(nombre).getProgreso() + " intentos: " + servidor.getJugador(nombre).getIntentos());
    }
}
