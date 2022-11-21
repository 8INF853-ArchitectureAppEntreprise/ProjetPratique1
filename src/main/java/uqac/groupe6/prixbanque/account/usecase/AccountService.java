package uqac.groupe6.prixbanque.account.usecase;

public interface AccountService {
	public void create(AccountRequestModel requestModel);

	public void loadOne(AccountRequestModel requestModel);

	public void loadAdd(AccountRequestModel requestModel);
}
