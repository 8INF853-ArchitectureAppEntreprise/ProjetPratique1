package uqac.groupe6.registration.usecase;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.registration.domain.User;
import uqac.groupe6.registration.persistance.CustomerJpaRepository;
import uqac.groupe6.registration.persistance.UserJPAEntity;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CustomerRegisterGatewayImpl implements CustomerRegisterGateway {

	private final CustomerJpaRepository customerJpaRepository;

	public void save(User user) {
		UserJPAEntity userJPAEntity = new UserJPAEntity(user.getFirstName(), user.getLastName(), user.getEmail(),
				user.getEmail(), user.getPassword(), user.getPhoneNumber(), user.getRole());

		customerJpaRepository.save(userJPAEntity);
	}

	@Override
	public User findByUsername(String username) {
		return customerJpaRepository.findByUsername(username).map(jpa -> {
			return User.builder().firstName(jpa.getFirstName()).build();
		}).orElse(null);
	}

	@Override
	public User findByEmail(String email) {
		return customerJpaRepository.findByEmail(email).map(jpa -> {
			return jpaToDomain(jpa);
		}).orElse(null);
	}

	private User jpaToDomain(UserJPAEntity jpaEntity) {
		return User.builder().email(jpaEntity.getEmail()).firstName(jpaEntity.getFirstName())
				.lastName(jpaEntity.getLastName()).password(jpaEntity.getPassword()).phoneNumber(jpaEntity.getMobile())
				.role(jpaEntity.getRole()).username(jpaEntity.getUsername()).build();
	}

}
