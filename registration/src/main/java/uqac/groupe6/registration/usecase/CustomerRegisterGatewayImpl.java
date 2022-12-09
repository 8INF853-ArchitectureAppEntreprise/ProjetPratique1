package uqac.groupe6.registration.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.registration.domain.Customer;
import uqac.groupe6.registration.persistance.CustomerJPAEntity;
import uqac.groupe6.registration.persistance.CustomerJpaRepository;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CustomerRegisterGatewayImpl implements CustomerRegisterGateway {

	private final CustomerJpaRepository customerJpaRepository;

	public void save(Customer user) {
		CustomerJPAEntity userJPAEntity = new CustomerJPAEntity(user.getFirstName(), user.getLastName(),
				user.getEmail(), user.getPassword(), user.getPhoneNumber(), user.getRole(), LocalDateTime.now(),
				LocalDateTime.now());

		customerJpaRepository.save(userJPAEntity);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerJpaRepository.findByEmail(email).map(jpa -> {
			return jpaToDomain(jpa);
		}).orElse(null);
	}

	private Customer jpaToDomain(CustomerJPAEntity jpaEntity) {
		return Customer.builder().email(jpaEntity.getEmail()).firstName(jpaEntity.getFirstName())
				.lastName(jpaEntity.getLastName()).password(jpaEntity.getPassword()).phoneNumber(jpaEntity.getMobile())
				.role(jpaEntity.getRole()).build();
	}

}
