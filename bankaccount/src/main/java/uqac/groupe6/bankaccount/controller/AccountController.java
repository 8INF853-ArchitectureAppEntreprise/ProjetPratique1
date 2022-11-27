package uqac.groupe6.bankaccount.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.usecase.AccountRequestModel;
import uqac.groupe6.bankaccount.usecase.AccountResponseModel;
import uqac.groupe6.bankaccount.usecase.AccountService;
import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

	private final AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity create(@RequestBody AccountRequestModel requestModel) {
		try {
			accountService.create(requestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("New account " + requestModel.getName() + " created");
		} catch (AccountNameAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public List<AccountResponseModel> getAccounts(@PathVariable("id") Long idCustomer) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(idCustomer, null, null);
		return accountService.loadAll(accountRequestModel);
	}

	@RequestMapping(value = "/customer/{idCustomer}/account/{idAccount}", method = RequestMethod.GET)
	public AccountResponseModel getOneAccount(@PathVariable("idCustomer") Long idCustomer,
			@PathVariable("idAccount") Long idAccount) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(idCustomer, idAccount, null);
		return accountService.loadOne(accountRequestModel);
	}

	@GetMapping
	public String mainPage() {
		return "main page account";
	}
}
