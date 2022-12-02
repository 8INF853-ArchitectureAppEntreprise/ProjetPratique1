package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import uqac.groupe6.bankaccount.usecase.exception.AccountDoestExistException;
import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

public interface AccountService {
	void create(AccountRequestModel requestModel) throws AccountNameAlreadyExistException;

	void update(AccountRequestModel requestModel) throws AccountDoestExistException;

	void delete(AccountRequestModel requestModel) throws AccountDoestExistException;

	AccountResponseModel getOneAccount(AccountRequestModel requestModel);

	List<AccountResponseModel> getAllAccounts(AccountRequestModel requestModel);

	List<AccountResponseModel> getAllAccountType(AccountRequestModel requestModel);
}
