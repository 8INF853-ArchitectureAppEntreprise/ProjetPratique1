package uqac.groupe6.banktransfert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BankTransfertApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankTransfertApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Welcome to Bank Transfert";
	}
}
