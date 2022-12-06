package uqac.groupe6.connection.usecase;

public interface ConnectionGateway {

    void save(ConnectionRequestModel dto);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);


}
