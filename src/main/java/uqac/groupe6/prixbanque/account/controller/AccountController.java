package uqac.groupe6.prixbanque.account.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.prixbanque.account.usecase.AccountRequestModel;
import uqac.groupe6.prixbanque.account.usecase.AccountService;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@PostMapping("/register")
	public void create(@RequestBody AccountRequestModel requestModel) {
		accountService.create(requestModel);
	}

	@GetMapping
	public String mainPage() {
		return "main page account";
	}
}
