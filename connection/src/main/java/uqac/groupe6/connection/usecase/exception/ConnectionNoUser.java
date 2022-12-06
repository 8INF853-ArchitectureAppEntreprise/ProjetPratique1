package uqac.groupe6.connection.usecase.exception;

public class ConnectionNoUser extends Exception{
    private static final long serialVersionUID = 1L;

    public ConnectionNoUser(String msg) {
        super(msg);
    }
}
