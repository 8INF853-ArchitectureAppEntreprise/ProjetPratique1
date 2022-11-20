package uqac.groupe6.prixbanque.customer.adapter.out.persistance;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.prixbanque.customer.adapter.out.persistance.requestModel.CustomerRepositoryDTO;
import uqac.groupe6.prixbanque.customer.usecase.port.out.CustomerRegisterPort;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CustomerPersistanceAdapter implements CustomerRegisterPort {

	private CustomerRepository jpaUserRepository;

	public void save(CustomerRepositoryDTO customerRepositoryDTO) {
		CustomerJpaEntity customerJpaEntity = new CustomerJpaEntity(customerRepositoryDTO.getEmail(),
				customerRepositoryDTO.getPassword(), LocalDateTime.now(), customerRepositoryDTO.getFirstName(),
				customerRepositoryDTO.getLastName(), customerRepositoryDTO.getPhoneNumber());

		jpaUserRepository.save(customerJpaEntity);
	}

	public boolean existsByEmail(String email) {
		return !jpaUserRepository.findByEmail(email).isEmpty();
	}

}
