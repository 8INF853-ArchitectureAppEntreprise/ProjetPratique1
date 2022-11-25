package uqac.groupe6.customer.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.customer.persistance.CustomerJpaEntity;
import uqac.groupe6.customer.persistance.CustomerJpaRepository;

@Getter
@Setter
@AllArgsConstructor
@Component
public class CustomerRegisterGatewayImpl implements CustomerRegisterGateway {

	private final CustomerJpaRepository customerJpaRepository;

	public void save(RegisterCustomerDTO customerRepositoryDTO) {
		CustomerJpaEntity customerJpaEntity = new CustomerJpaEntity(customerRepositoryDTO.getEmail(),
				customerRepositoryDTO.getPassword(), LocalDateTime.now(), customerRepositoryDTO.getFirstName(),
				customerRepositoryDTO.getLastName(), customerRepositoryDTO.getPhoneNumber());

		customerJpaRepository.save(customerJpaEntity);
	}

	public boolean existsByEmail(String email) {
		return !customerJpaRepository.findByEmail(email).isEmpty();
	}

}
