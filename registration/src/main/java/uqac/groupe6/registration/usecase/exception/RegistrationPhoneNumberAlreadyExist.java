package uqac.groupe6.registration.usecase.exception;

public class RegistrationPhoneNumberAlreadyExist extends Exception{

    private static final long serialVersionUID = 1L;

    public RegistrationPhoneNumberAlreadyExist(String msg) {
        super(msg);
    }
}