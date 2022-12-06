package uqac.groupe6.connection.usecase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import uqac.groupe6.connection.usecase.exception.ConnectionNoID;

public class ConnectionCustomServiceImp implements ConnectionCustomService{

    @Override
    public void register(ConnectionRequestModel dto) throws ConnectionNoID {
        if(dto.getEmail() == null && dto.getPhoneNumber() == null){
            throw new ConnectionNoID(
                    "No identifiant to find in BDD");

        }

    }
}
