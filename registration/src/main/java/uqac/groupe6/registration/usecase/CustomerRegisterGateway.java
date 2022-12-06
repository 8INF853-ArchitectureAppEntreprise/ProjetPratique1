package uqac.groupe6.registration.usecase;

public interface CustomerRegisterGateway {
	void save(RegisterCustomerDTO customerRepositoryDTO);

	boolean existsByEmail(String email);

	boolean existsByPhoneNumber(String phoneNumber);

}
