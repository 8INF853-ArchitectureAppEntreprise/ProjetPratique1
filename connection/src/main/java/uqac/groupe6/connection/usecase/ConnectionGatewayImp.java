package uqac.groupe6.connection.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uqac.groupe6.connection.domain.User;
import uqac.groupe6.connection.persistance.ConnectionJpaEntity;
import uqac.groupe6.connection.persistance.ConnectionJpaRepository;

@Getter
@Setter
@AllArgsConstructor
@Component
public class ConnectionGatewayImp implements ConnectionGateway{

    private final ConnectionJpaRepository connectionJpaRepository;

    @Override
    public ConnectionJpaEntity login(ConnectionRequestModel dto) {
        if(existsByEmail(dto.getEmail())){
            return connectionJpaRepository.findByEmail(dto.getEmail()).get();

        } else if (existsByPhoneNumber(dto.getPhoneNumber())) {
            return connectionJpaRepository.findByPhoneNumber(dto.getPhoneNumber()).get();
        }
        else
            return null;

    }

    @Override
    public boolean existsByEmail(String email) {
        return !connectionJpaRepository.findByEmail(email).isEmpty();
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        return !connectionJpaRepository.findByPhoneNumber(phoneNumber).isEmpty();
    }
}
