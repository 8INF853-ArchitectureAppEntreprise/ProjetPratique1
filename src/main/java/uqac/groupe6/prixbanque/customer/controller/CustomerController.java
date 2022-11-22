package uqac.groupe6.prixbanque.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.prixbanque.customer.usecase.RegisterCustomerDTO;
import uqac.groupe6.prixbanque.customer.usecase.RegisterCustomerService;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

	private final RegisterCustomerService customerService;

	@PostMapping("/register")
	String create(@RequestBody RegisterCustomerDTO requestModel) {
		customerService.register(requestModel);
		return "ok";
	}

	@GetMapping
	public String mainPage() {
		return "main page customer";
	}
}
