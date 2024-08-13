package distribuidos.JuegoAhorcado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JuegoAhorcadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuegoAhorcadoApplication.class, args);
	}

}
