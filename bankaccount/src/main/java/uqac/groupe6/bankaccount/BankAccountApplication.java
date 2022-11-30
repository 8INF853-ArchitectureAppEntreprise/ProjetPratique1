package uqac.groupe6.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@EnableJpaRepositories(basePackages = { "uqac.groupe6.registration.persistance",
//		"uqac.groupe6.bankaccount.persistance" })
//@EntityScan(basePackages = { "uqac.groupe6.registration.persistance", "uqac.groupe6.bankaccount.persistance" })
@SpringBootApplication
@RestController
public class BankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Welcome to Bank Account";
	}
}
