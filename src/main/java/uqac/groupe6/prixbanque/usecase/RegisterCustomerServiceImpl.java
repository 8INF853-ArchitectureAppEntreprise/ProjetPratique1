package uqac.groupe6.prixbanque.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegisterCustomerServiceImpl implements RegisterCustomerService {

	@Autowired
	private final CustomerRegisterGateway customerRegisterGateway;

	@Override
	public void register(RegisterCustomerDTO dto) {
		customerRegisterGateway.save(dto);
	}

}
