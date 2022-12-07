package uqac.groupe6.registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.usecase.RegisterCustomerDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerService;
import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationNoCustomerExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

import java.util.List;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

	private final RegisterCustomerService customerService;

	@PostMapping("/register")
	ResponseEntity create(@RequestBody RegisterCustomerDTO requestModel) {

		try {
			customerService.register(requestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("New account created");
		} catch (RegistrationMailAlreadyExist | RegistrationPhoneNumberAlreadyExist | RegistrationMDPmatch e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Long idCustomer, @RequestBody RegisterCustomerDTO dto) {
		//requestModel.setIdAccount(idAccount);

		try {
			customerService.update(dto, idCustomer);
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer with id: " + idCustomer + " is update");
		} catch (RegistrationNoCustomerExist | RegistrationMDPmatch e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@GetMapping
	public String mainPage() {
		return "main page customer";
	}
}
