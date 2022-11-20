package adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import usecase.CustomerRequestModel;
import usecase.CustomerResponseModel;
import usecase.UserRegisterInteractor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/customer")
class UserRegisterController {

	private UserRegisterInteractor userInput;

	@PostMapping
	CustomerResponseModel create(@RequestBody CustomerRequestModel requestModel) {
		System.out.println("Ookkk");
		return userInput.create(requestModel);
	}

	@GetMapping("/toto")
	public String toto() {
		return "ttoto";
	}
}