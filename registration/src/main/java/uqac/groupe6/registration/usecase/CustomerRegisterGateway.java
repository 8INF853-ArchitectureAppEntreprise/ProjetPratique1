package uqac.groupe6.registration.usecase;

public interface CustomerRegisterGateway {
	void save(RegisterCustomerDTO customerRepositoryDTO);

	boolean existsByEmail(String email);

	boolean existsByPhoneNumber(String phoneNumber);

	boolean existsById(Long id);

	boolean pwdMatchBdd(String pwd, Long id);

	void update(RegisterCustomerDTO dto, Long id);
}
