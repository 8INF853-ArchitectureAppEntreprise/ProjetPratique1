package uqac.groupe6.connection.usecase.exception;

public class ConnectionPasswordWrong extends Exception{

    private static final long serialVersionUID = 1L;

    public ConnectionPasswordWrong(String msg) {
        super(msg);
    }
}
