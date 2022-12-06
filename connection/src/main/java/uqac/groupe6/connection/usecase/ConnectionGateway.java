package uqac.groupe6.connection.usecase;

import uqac.groupe6.connection.domain.User;
import uqac.groupe6.connection.persistance.ConnectionJpaEntity;

public interface ConnectionGateway {

    ConnectionJpaEntity login(ConnectionRequestModel dto);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);


}
