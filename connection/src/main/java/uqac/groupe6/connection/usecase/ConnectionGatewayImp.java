package uqac.groupe6.connection.usecase;

public class ConnectionGatewayImp implements ConnectionGateway{
    @Override
    public void save(ConnectionRequestModel dto) {

    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return false;
    }
}
