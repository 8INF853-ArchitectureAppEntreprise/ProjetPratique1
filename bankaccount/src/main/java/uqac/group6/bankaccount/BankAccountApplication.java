package uqac.group6.bankaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
