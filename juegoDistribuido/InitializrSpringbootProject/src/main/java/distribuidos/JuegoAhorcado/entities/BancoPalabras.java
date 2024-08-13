package distribuidos.JuegoAhorcado.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class BancoPalabras {

    @Value("${palabras}")
    private String palabrasString;

    private List<String> palabras;

    private final Random random = new Random();

    public String obtenerPalabraAlAzar() {
        inicializarPalabras();
        int indicePalabra = random.nextInt(palabras.size());
        return palabras.get(indicePalabra);
    }

    private void inicializarPalabras() {
        if (palabras == null) {
            palabras = Arrays.asList(palabrasString.split(","));
        }
    }
}