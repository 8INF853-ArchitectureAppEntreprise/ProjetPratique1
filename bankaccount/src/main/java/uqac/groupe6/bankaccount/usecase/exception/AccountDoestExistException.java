package uqac.groupe6.bankaccount.usecase.exception;

public class AccountDoestExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public AccountDoestExistException(String msg) {
		super(msg);
	}
}
