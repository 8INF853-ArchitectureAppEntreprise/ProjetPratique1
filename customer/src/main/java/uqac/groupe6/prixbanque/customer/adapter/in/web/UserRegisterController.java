package uqac.groupe6.prixbanque.customer.adapter.in.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import uqac.groupe6.prixbanque.customer.usecase.CustomerRegisterService;
import uqac.groupe6.prixbanque.customer.usecase.CustomerResponseModel;
import uqac.groupe6.prixbanque.customer.usecase.port.in.requestModel.CustomerRequestModel;

@Controller
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
class UserRegisterController {

	private final CustomerRegisterService customerRegisterService;

	@PostMapping
	CustomerResponseModel create(@RequestBody CustomerRequestModel requestModel) {
		System.out.println("Ookkk");
		return customerRegisterService.register(requestModel);
	}

	@GetMapping("/toto")
	public String toto() {
		return "ttoto";
	}
}