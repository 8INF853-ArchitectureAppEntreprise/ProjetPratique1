package uqac.groupe6.registration.usecase.exception;

public class RegistrationMailAlreadyExist extends Exception {

    private static final long serialVersionUID = 1L;

    public RegistrationMailAlreadyExist(String msg) {
        super(msg);
    }
}