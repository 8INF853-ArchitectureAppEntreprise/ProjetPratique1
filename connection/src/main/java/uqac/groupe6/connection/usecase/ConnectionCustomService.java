package uqac.groupe6.connection.usecase;

import uqac.groupe6.connection.domain.User;
import uqac.groupe6.connection.usecase.exception.ConnectionNoID;
import uqac.groupe6.connection.usecase.exception.ConnectionNoUser;
import uqac.groupe6.connection.usecase.exception.ConnectionPasswordWrong;

public interface ConnectionCustomService {
    User login(ConnectionRequestModel dto) throws ConnectionNoID, ConnectionNoUser, ConnectionPasswordWrong;
}
