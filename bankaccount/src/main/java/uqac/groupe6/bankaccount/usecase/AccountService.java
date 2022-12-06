package uqac.groupe6.bankaccount.usecase;

import java.util.List;

import uqac.groupe6.bankaccount.usecase.exception.AccountDoestExistException;
import uqac.groupe6.bankaccount.usecase.exception.AccountNameAlreadyExistException;

public interface AccountService {

	/**
	 * Create a new account
	 * 
	 * @param requestModel contains account informations
	 * @throws AccountNameAlreadyExistException
	 */
	void create(AccountRequestModel requestModel) throws AccountNameAlreadyExistException;

	/**
	 * Update an account
	 * 
	 * @param requestModel contains account informations
	 * @throws AccountDoestExistException
	 */
	void update(AccountRequestModel requestModel) throws AccountDoestExistException;

	/**
	 * Delete an account
	 * 
	 * @param requestModel contains account informations
	 * @throws AccountDoestExistException
	 */
	void delete(AccountRequestModel requestModel) throws AccountDoestExistException;

	/**
	 * @param requestModel contains account informations
	 * @return the account corresponding to the requestModel
	 */
	AccountResponseModel getOneAccount(AccountRequestModel requestModel);

	/**
	 * @param requestModel contains account informations
	 * @return accounts from the same customer
	 */
	List<AccountResponseModel> getAllAccounts(AccountRequestModel requestModel);

	/**
	 * @param requestModel contains account informations
	 * @return accounts following the same account type
	 */
	List<AccountResponseModel> getAllAccountType(AccountRequestModel requestModel);
}
