package uqac.groupe6.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.usecase.LoginDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerDTO;
import uqac.groupe6.registration.usecase.RegisterCustomerService;

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
	public void create(@RequestBody RegisterCustomerDTO requestModel) {
		registerCustomerService.register(requestModel);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),
				loginDTO.getPassword());
		// we let the manager do its job.
		authenticationManager.authenticate(token);
		// if there is no exception thrown from authentication manager,
		// we can generate a JWT token and give it to user.
		String jwt = jwtUtil.generate(loginDTO.getEmail());
		return ResponseEntity.ok(jwt);
	}

	@GetMapping
	public String mainPage() {
		return "main page customer";
	}
}
