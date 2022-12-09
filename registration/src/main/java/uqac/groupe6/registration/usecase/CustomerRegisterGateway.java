package uqac.groupe6.registration.usecase;

import uqac.groupe6.registration.domain.Customer;

public interface CustomerRegisterGateway {
	void save(Customer user);

	Customer findByEmail(String email);
}
