package uqac.groupe6.bankaccount.usecase;

import java.util.List;

public interface AccountService {
	public void create(AccountRequestModel requestModel);

	public AccountResponseModel loadOne(AccountRequestModel requestModel);

	public List<AccountResponseModel> loadAll(AccountRequestModel requestModel);
}
