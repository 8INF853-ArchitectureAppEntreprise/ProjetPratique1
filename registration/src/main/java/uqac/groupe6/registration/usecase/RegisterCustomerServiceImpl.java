package uqac.groupe6.registration.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

@AllArgsConstructor
@Service
public class RegisterCustomerServiceImpl implements RegisterCustomerService {

	@Autowired
	private final CustomerRegisterGateway customerRegisterGateway;

	@Override
	public void register(RegisterCustomerDTO dto) throws RegistrationMailAlreadyExist, RegistrationPhoneNumberAlreadyExist, RegistrationMDPmatch {
		if(!dto.getMatchedPassword().equals(dto.getPassword())){
			throw new RegistrationMDPmatch(
					"Password don't match");

		}
		else if(customerRegisterGateway.existsByEmail(dto.getEmail())){
			throw new RegistrationMailAlreadyExist(
					"Account with email " + dto.getEmail() + " already exist");
		}
		else if(customerRegisterGateway.existsByPhoneNumber(dto.getPhoneNumber())){
			throw new RegistrationPhoneNumberAlreadyExist(
					"Account with phone number " + dto.getPhoneNumber() + " already exist");
		}

		customerRegisterGateway.save(dto);
	}

}
