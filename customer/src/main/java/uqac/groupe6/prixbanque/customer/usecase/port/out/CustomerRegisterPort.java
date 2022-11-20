package uqac.groupe6.prixbanque.customer.usecase.port.out;

import uqac.groupe6.prixbanque.customer.adapter.out.persistance.requestModel.CustomerRepositoryDTO;

public interface CustomerRegisterPort {
	void save(CustomerRepositoryDTO customerRepositoryDTO);

	boolean existsByEmail(String email);
}
