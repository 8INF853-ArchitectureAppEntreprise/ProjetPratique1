package uqac.groupe6.prixbanque.customer.usecase.port.in;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uqac.groupe6.prixbanque.customer.adapter.out.persistance.requestModel.CustomerRepositoryDTO;
import uqac.groupe6.prixbanque.customer.usecase.CustomerRegisterService;
import uqac.groupe6.prixbanque.customer.usecase.CustomerResponseModel;
import uqac.groupe6.prixbanque.customer.usecase.port.in.requestModel.CustomerRequestModel;
import uqac.groupe6.prixbanque.customer.usecase.port.out.CustomerRegisterPort;
import uqac.groupe6.prixbanque.customer.usecase.port.out.PasswordEncoder;

@Getter
@Setter
@AllArgsConstructor
@Service
public class CustomerRegisterUseCase implements CustomerRegisterService {

	private final CustomerRegisterPort repositoryGateway;

	private final PasswordEncoder passwordEncoder;

	public CustomerResponseModel register(CustomerRequestModel customerRequestModel) {
		String passwordEncoded = passwordEncoder.encode(customerRequestModel.getPassword());

		CustomerRepositoryDTO customerRepositoryDTO = new CustomerRepositoryDTO(customerRequestModel.getEmail(),
				passwordEncoded, customerRequestModel.getFirstName(), customerRequestModel.getLastName(),
				customerRequestModel.getPhoneNumber());

		repositoryGateway.save(customerRepositoryDTO);

		return null;
	}

}
