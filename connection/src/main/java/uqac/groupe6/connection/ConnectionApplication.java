package uqac.groupe6.connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Welcome to Connection";
	}
}
