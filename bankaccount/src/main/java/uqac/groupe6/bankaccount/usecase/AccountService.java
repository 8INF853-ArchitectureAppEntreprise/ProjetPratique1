package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

public interface AccountService {
	public void create(AccountRequestModel requestModel) throws AccountNameAlreadyExistException;

	public AccountResponseModel loadOne(AccountRequestModel requestModel);

	public List<AccountResponseModel> loadAll(AccountRequestModel requestModel);
}
