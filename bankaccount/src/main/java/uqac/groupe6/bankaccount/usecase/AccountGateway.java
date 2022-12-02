package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.domain.AccountType;

public interface AccountGateway {

	/**
	 * @param idCustomer  the customer id
	 * @param accountName the account name
	 */
	void create(Long idCustomer, String accountName, AccountType accountType);

	/**
	 * @param accountId      the account id
	 * @param newAccountName the new account name
	 */
	void updateName(Long accountId, String newAccountName);

	/**
	 * @param idAccount the account id
	 */
	void delete(Long idAccount);

	/**
	 * @param idCustomer
	 * @return an account or null if doesn't exist
	 */
	Account findByAccountId(Long idAccount);

	/**
	 * @param idCustomer the customer id
	 * @param name       the account name
	 * @return an account or null if doesn't exist
	 */
	Account findByCustomerIdAndByName(Long idCustomer, String name);

	/**
	 * @param idCustomer the customer id
	 * @param idAccount  the account id
	 * @return an account or null if doesn't exist
	 */
	Account findByCustomerIdAndAccountId(Long idCustomer, Long idAccount);

	/**
	 * @param idCustomer the customer id
	 * @return a list of all customer's account
	 */
	List<Account> findAllAccounts(Long idCustomer);

	/**
	 * 
	 * @param accountType the account type
	 * @return the list of account
	 */
	List<Account> findByCustomerIdAndAccountType(Long customerId, AccountType accountType);
}
