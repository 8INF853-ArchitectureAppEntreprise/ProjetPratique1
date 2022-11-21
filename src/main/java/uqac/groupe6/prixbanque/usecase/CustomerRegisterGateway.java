package uqac.groupe6.prixbanque.usecase;

public interface CustomerRegisterGateway {
	void save(RegisterCustomerDTO customerRepositoryDTO);

	boolean existsByEmail(String email);

}
