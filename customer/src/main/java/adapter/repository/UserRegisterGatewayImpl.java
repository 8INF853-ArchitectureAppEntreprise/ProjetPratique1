package adapter.repository;

import java.time.LocalDateTime;

import adapter.repository.requestModel.CustomerRepositoryDTO;
import domain.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import usecase.port.UserRegisterGateway;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterGatewayImpl implements UserRegisterGateway {

	private CustomerDAO jpaUserRepository;

	public void save(CustomerRepositoryDTO customerRepositoryDTO) {
		CustomerJpaEntity customerJpaEntity = new CustomerJpaEntity(customerRepositoryDTO.getEmail(),
				customerRepositoryDTO.getPassword(), LocalDateTime.now(), customerRepositoryDTO.getFirstName(),
				customerRepositoryDTO.getLastName(), customerRepositoryDTO.getPhoneNumber(), new Account());

		jpaUserRepository.save(customerJpaEntity);
	}

	public boolean existsByEmail(String email) {
		return !jpaUserRepository.findByEmail(email).isEmpty();
	}

}
