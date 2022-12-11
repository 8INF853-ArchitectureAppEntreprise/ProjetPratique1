package uqac.groupe6.registration.usecase;

import uqac.groupe6.registration.domain.Customer;

public interface CustomerRegisterGateway {
	void save(Customer user);

	boolean existsByPhoneNumber(String phoneNumber);

	boolean existsById(Long id);

	boolean existsByEmail(String email);

	boolean pwdMatchBdd(String pwd, Long id);

	void update(RegisterCustomerDTO dto, Long id);

	Customer findByEmail(String email);
}
