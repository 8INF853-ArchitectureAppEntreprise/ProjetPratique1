package uqac.groupe6.registration.usecase;

import uqac.groupe6.registration.domain.User;

public interface CustomerRegisterGateway {
	void save(User user);

	User findByEmail(String email);

	User findByUsername(String username);

}
