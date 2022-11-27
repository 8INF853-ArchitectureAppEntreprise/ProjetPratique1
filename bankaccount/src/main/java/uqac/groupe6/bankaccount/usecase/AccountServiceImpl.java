package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountGateway accountGateway;

	@Override
	public void create(AccountRequestModel requestModel) throws AccountNameAlreadyExistException {
		Account accountAlreadyExist = accountGateway.findByCustomer_IdAndByName(requestModel.getIdCustomer(),
				requestModel.getName());

		if (accountAlreadyExist != null && accountAlreadyExist.getName().equals(requestModel.getName())) {
			throw new AccountNameAlreadyExistException(
					"Account with name " + requestModel.getName() + " already exist");
		}

		accountGateway.create(requestModel.getIdCustomer(), requestModel.getName());
	}

	@Override
	public AccountResponseModel loadOne(AccountRequestModel requestModel) {
		Account account = accountGateway.getOne(requestModel.getIdCustomer(), requestModel.getIdAccount());
		return accountToResponseModel(account);
	}

	@Override
	public List<AccountResponseModel> loadAll(AccountRequestModel requestModel) {
		List<Account> customerAccounts = accountGateway.getAll(requestModel.getIdCustomer());

		return customerAccounts.stream().map(account -> accountToResponseModel(account)).toList();
	}

	private AccountResponseModel accountToResponseModel(Account account) {
		return AccountResponseModel.builder().name(account.getName()).build();
	}
}
