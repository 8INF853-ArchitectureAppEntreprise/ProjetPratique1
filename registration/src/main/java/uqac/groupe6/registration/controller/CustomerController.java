package uqac.groupe6.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.security.JwtUtil;
import uqac.groupe6.registration.usecase.LoginDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerService;
import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationNoCustomerExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor
public class CustomerController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	private RegisterCustomerService registerCustomerService;

	@PostMapping("/register")
	public ResponseEntity create(@RequestBody RegisterCustomerDTO requestModel) {

		try {
			registerCustomerService.register(requestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("New account created");
		} catch (RegistrationMailAlreadyExist | RegistrationPhoneNumberAlreadyExist | RegistrationMDPmatch e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Long idCustomer, @RequestBody RegisterCustomerDTO dto) {
		// requestModel.setIdAccount(idAccount);

		try {
			registerCustomerService.update(dto, idCustomer);
			return ResponseEntity.status(HttpStatus.CREATED).body("Customer with id: " + idCustomer + " is update");
		} catch (RegistrationNoCustomerExist | RegistrationMDPmatch e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
				loginDTO.getPassword());
		authenticationManager.authenticate(token);

		String jwt = jwtUtil.generate(loginDTO.getEmail());
		return ResponseEntity.ok(jwt);
	}

	@PostMapping("/validateToken")
	public ResponseEntity<Boolean> validateToken(@RequestParam String token) {
		return ResponseEntity.ok(jwtUtil.validate(token));
	}

	@GetMapping
	public String hello() {
		return "Welcome to Registration";
	}
}
