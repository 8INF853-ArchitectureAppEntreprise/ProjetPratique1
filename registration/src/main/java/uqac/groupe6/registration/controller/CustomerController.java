package uqac.groupe6.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.usecase.RegisterCustomerDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerService;
import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

	private final RegisterCustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity create(@RequestBody RegisterCustomerDTO requestModel) {

		try {
			customerService.register(requestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("New account created");
		} catch (RegistrationMailAlreadyExist | RegistrationPhoneNumberAlreadyExist | RegistrationMDPmatch e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@GetMapping
	public String mainPage() {
		return "main page customer";
	}
}
