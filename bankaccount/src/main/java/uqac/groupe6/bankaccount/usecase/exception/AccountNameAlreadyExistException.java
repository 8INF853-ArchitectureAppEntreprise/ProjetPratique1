package uqac.groupe6.bankaccount.usecase.exception;

public class AccountNameAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public AccountNameAlreadyExistException(String msg) {
		super(msg);
	}

}
