package uqac.groupe6.prixbanque.account.usecase;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountGateway accountGateway;

	@Override
	public void create(AccountRequestModel requestModel) {
		accountGateway.create(requestModel.getIdCustomer(), requestModel.getName());
	}

	@Override
	public void loadOne(AccountRequestModel requestModel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadAdd(AccountRequestModel requestModel) {
		// TODO Auto-generated method stub

	}

}
