package uqac.groupe6.registration.usecase;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.registration.domain.User;
import uqac.groupe6.registration.persistance.CustomerJpaRepository;
import uqac.groupe6.registration.persistance.UserJPAEntity;

@Getter
@Setter
@AllArgsConstructor
@Component
public class CustomerRegisterGatewayImpl implements CustomerRegisterGateway {

	private final CustomerJpaRepository customerJpaRepository;

	public void save(User user) {
		String username = user.getLastName() + "_" + user.getFirstName();

		UserJPAEntity userJPAEntity = new UserJPAEntity(user.getFirstName(), user.getLastName(), user.getEmail(),
				username, user.getPassword(), user.getPhoneNumber(), user.getRole());

		customerJpaRepository.save(userJPAEntity);
	}

	public boolean existsByEmail(String email) {
		return !customerJpaRepository.findByEmail(email).isEmpty();
	}

	@Override
	public User findByUsername(String username) {
		return customerJpaRepository.findByUsername(username).map(jpa -> {
			return User.builder().firstName(jpa.getFirstName()).build();
		}).orElse(null);
	}

	private User jpaToDomain(UserJPAEntity user) {
		return null;
	}

}
