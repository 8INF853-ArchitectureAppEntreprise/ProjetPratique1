package uqac.groupe6.bankaccount.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.usecase.AccountRequestModel;
import uqac.groupe6.bankaccount.usecase.AccountResponseModel;
import uqac.groupe6.bankaccount.usecase.AccountService;
import uqac.groupe6.bankaccount.usecase.exception.AccountDoestExistException;
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

	@PutMapping("/update/{id}")
	public ResponseEntity update(@PathVariable("id") Long idAccount, @RequestBody AccountRequestModel requestModel) {
		requestModel.setIdAccount(idAccount);

		try {
			accountService.update(requestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("Account name update");
		} catch (AccountDoestExistException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") Long idAccount) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(null, idAccount, null, null);
		try {
			accountService.delete(accountRequestModel);
			return ResponseEntity.status(HttpStatus.CREATED).body("Account deleted");
		} catch (AccountDoestExistException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public List<AccountResponseModel> getAccounts(@PathVariable("id") Long idCustomer) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(idCustomer, null, null, null);
		return accountService.getAllAccounts(accountRequestModel);
	}

	@RequestMapping(value = "/customer/{idCustomer}/account/{idAccount}", method = RequestMethod.GET)
	public AccountResponseModel getOneAccount(@PathVariable("idCustomer") Long idCustomer,
			@PathVariable("idAccount") Long idAccount) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(idCustomer, idAccount, null, null);
		return accountService.getOneAccount(accountRequestModel);
	}

	@RequestMapping(value = "/customer/{idCustomer}/type/{accountType}")
	public List<AccountResponseModel> getAccountsType(@PathVariable("idCustomer") Long idCustomer,
			@PathVariable("accountType") String accountType) {
		AccountRequestModel accountRequestModel = new AccountRequestModel(idCustomer, null, null, accountType);
		return accountService.getAllAccountType(accountRequestModel);
	}

	@GetMapping
	public String mainPage() {
		return "main page account";
	}
}
