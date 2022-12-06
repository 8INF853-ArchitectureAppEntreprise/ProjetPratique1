package uqac.groupe6.connection.usecase;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uqac.groupe6.connection.domain.User;
import uqac.groupe6.connection.persistance.ConnectionJpaEntity;
import uqac.groupe6.connection.usecase.exception.ConnectionNoID;
import uqac.groupe6.connection.usecase.exception.ConnectionNoUser;
import uqac.groupe6.connection.usecase.exception.ConnectionPasswordWrong;

@AllArgsConstructor
@Service
public class ConnectionCustomServiceImp implements ConnectionCustomService{

    @Autowired
    private final ConnectionGateway connectionGateway;

    @Override
    public User login(ConnectionRequestModel dto) throws ConnectionNoID, ConnectionNoUser, ConnectionPasswordWrong {
        if(dto.getEmail() == null && dto.getPhoneNumber() == null){
            throw new ConnectionNoID(
                    "No identifiant to find in BDD");

        }

        ConnectionJpaEntity userBDD = connectionGateway.login(dto);

        if(userBDD == null){
            throw new ConnectionNoUser("No user exist");
        }
        else if(!userBDD.getPassword().equals(dto.getPassword())){
            throw new ConnectionPasswordWrong("Password wrong");
        }

        return new User(userBDD.getEmail(), userBDD.getFirstName(), userBDD.getLastName(), userBDD.getPhoneNumber());

    }
}
