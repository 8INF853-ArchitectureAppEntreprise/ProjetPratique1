package uqac.groupe6.connection.usecase;

import uqac.groupe6.connection.usecase.exception.ConnectionNoID;

public interface ConnectionCustomService {
    void register(ConnectionRequestModel dto) throws ConnectionNoID;
}
