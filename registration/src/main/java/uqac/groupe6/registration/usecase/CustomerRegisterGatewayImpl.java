package uqac.groupe6.registration.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.registration.persistance.CustomerJpaEntity;
import uqac.groupe6.registration.persistance.CustomerJpaRepository;

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

	public void update(RegisterCustomerDTO dto, Long id){
		CustomerJpaEntity customerJpa = customerJpaRepository.findById(id).get();

		if(dto.getNewPassword() != null)
			customerJpa.setPassword(dto.getNewPassword());

		if(dto.getEmail() != null)
			customerJpa.setEmail(dto.getEmail());

		if(dto.getPhoneNumber() != null)
			customerJpa.setPhoneNumber(dto.getPhoneNumber());

		customerJpaRepository.save(customerJpa);
	}

	public boolean existsByEmail(String email) {
		return !customerJpaRepository.findByEmail(email).isEmpty();
	}

	public boolean existsByPhoneNumber(String phoneNumber){
		return !customerJpaRepository.findByPhoneNumber(phoneNumber).isEmpty();
	}

	@Override
	public boolean existsById(Long id) {
		return !customerJpaRepository.findById(id).isEmpty();
	}

	@Override
	public boolean pwdMatchBdd(String pwd, Long id) {
		CustomerJpaEntity customerJpa = customerJpaRepository.findById(id).get();

		return pwd.equals(customerJpa.getPassword());
	}

}
