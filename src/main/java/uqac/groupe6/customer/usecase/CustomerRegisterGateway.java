package uqac.groupe6.customer.usecase;

public interface CustomerRegisterGateway {
	void save(RegisterCustomerDTO customerRepositoryDTO);

	boolean existsByEmail(String email);

}
