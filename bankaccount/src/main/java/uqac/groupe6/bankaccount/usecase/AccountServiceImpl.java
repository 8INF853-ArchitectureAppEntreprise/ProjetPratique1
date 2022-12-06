package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.domain.AccountType;
import uqac.groupe6.bankaccount.usecase.exception.AccountDoestExistException;
import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountGateway accountGateway;

	@Override
	public void create(AccountRequestModel requestModel) throws AccountNameAlreadyExistException {
		Account accountAlreadyExist = accountGateway.findByCustomerIdAndByName(requestModel.getIdCustomer(),
				requestModel.getName());

		if (accountAlreadyExist != null && accountAlreadyExist.getName().equals(requestModel.getName())) {
			throw new AccountNameAlreadyExistException(
					"Account with name " + requestModel.getName() + " already exist");
		}

		if (!requestModel.getAccountType().equals(AccountType.CHEQUE.name())
				&& !requestModel.getAccountType().equals(AccountType.EPARGNE.name())) {
			throw new IllegalArgumentException("The account type " + requestModel.getAccountType() + " doesn't exist");
		}

		accountGateway.create(requestModel.getIdCustomer(), requestModel.getName(),
				AccountType.valueOf(requestModel.getAccountType()));
	}

	@Override
	public void update(AccountRequestModel requestModel) throws AccountDoestExistException {
		Account account = accountGateway.findByAccountId(requestModel.getIdAccount());

		if (account == null) {
			throw new AccountDoestExistException("Account to update doesn't exist");
		}

		accountGateway.updateName(requestModel.getIdAccount(), requestModel.getName());
	}

	@Override
	public void delete(AccountRequestModel requestModel) throws AccountDoestExistException {
		Account account = accountGateway.findByAccountId(requestModel.getIdAccount());

		if (account == null) {
			throw new AccountDoestExistException("Account with name " + requestModel.getName() + " doesn't exist");
		}

		accountGateway.delete(requestModel.getIdAccount());
	}

	@Override
	public AccountResponseModel getOneAccount(AccountRequestModel requestModel) {
		Account account = accountGateway.findByCustomerIdAndAccountId(requestModel.getIdCustomer(),
				requestModel.getIdAccount());
		return domainToResponseModel(account);
	}

	@Override
	public List<AccountResponseModel> getAllAccounts(AccountRequestModel requestModel) {
		List<Account> customerAccounts = accountGateway.findAllAccounts(requestModel.getIdCustomer());

		return customerAccounts.stream().map(account -> domainToResponseModel(account)).toList();
	}

	@Override
	public List<AccountResponseModel> getAllAccountType(AccountRequestModel requestModel) {
		List<Account> accounts = accountGateway.findByCustomerIdAndAccountType(requestModel.getIdCustomer(),
				AccountType.valueOf(requestModel.getAccountType()));

		return accounts.stream().map(account -> domainToResponseModel(account)).toList();
	}

	private AccountResponseModel domainToResponseModel(Account account) {
		return AccountResponseModel.builder().name(account.getName()).accountType(account.getAccountType().name())
				.balanceAmount(account.getBalance().getAmount()).build();
	}
}
