package uqac.groupe6.prixbanque.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = { "uqac.groupe6.prixbanque.customer.adapter",
		"uqac.groupe6.prixbanque.customer.usecase", "uqac.groupe6.prixbanque.customer.domain" })
@RestController
public class CustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@GetMapping
	public String hello() {
		return "Customer";
	}
}
