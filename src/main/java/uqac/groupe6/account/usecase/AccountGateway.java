package uqac.groupe6.account.usecase;

import java.util.List;

import uqac.groupe6.account.domain.Account;

public interface AccountGateway {
	void create(Long idCustomer, String accountName);

	Account getOne(Long idCustomer, Long idAccount);

	List<Account> getAll(Long idCustomer);
}
