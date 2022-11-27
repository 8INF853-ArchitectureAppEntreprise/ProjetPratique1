package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import uqac.groupe6.bankaccount.domain.Account;

public interface AccountGateway {
	void create(Long idCustomer, String accountName);

	Account findByCustomer_IdAndByName(Long idCustomer, String name);

	Account getOne(Long idCustomer, Long idAccount);

	List<Account> getAll(Long idCustomer);
}
