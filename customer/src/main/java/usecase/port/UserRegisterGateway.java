package usecase.port;

import adapter.repository.requestModel.CustomerRepositoryDTO;

public interface UserRegisterGateway {
	void save(CustomerRepositoryDTO customerRepositoryDTO);

	boolean existsByEmail(String email);
}
