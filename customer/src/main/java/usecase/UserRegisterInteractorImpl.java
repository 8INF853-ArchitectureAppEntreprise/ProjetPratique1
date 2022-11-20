package usecase;

import org.springframework.stereotype.Service;

import adapter.repository.requestModel.CustomerRepositoryDTO;
import lombok.Getter;
import lombok.Setter;
import usecase.port.PasswordEncoder;
import usecase.port.UserRegisterGateway;

@Service
@Getter
@Setter
public class UserRegisterInteractorImpl implements UserRegisterInteractor {

	private final UserRegisterGateway repositoryGateway;

	private final PasswordEncoder passwordEncoder;

	public UserRegisterInteractorImpl(final UserRegisterGateway repositoryGateway,
			final PasswordEncoder passwordEncoder) {
		super();
		this.repositoryGateway = repositoryGateway;
		this.passwordEncoder = passwordEncoder;
	}

	public CustomerResponseModel create(CustomerRequestModel customerRequestModel) {
		String passwordEncoded = passwordEncoder.encode(customerRequestModel.getPassword());

		CustomerRepositoryDTO customerRepositoryDTO = new CustomerRepositoryDTO(customerRequestModel.getEmail(),
				passwordEncoded, customerRequestModel.getFirstName(), customerRequestModel.getLastName(),
				customerRequestModel.getPhoneNumber());

		repositoryGateway.save(customerRepositoryDTO);

		return null;
	}

}
