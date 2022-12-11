package uqac.groupe6.registration.usecase;

import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationNoCustomerExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

public interface RegisterCustomerService {
	void register(RegisterCustomerDTO dto)
			throws RegistrationMailAlreadyExist, RegistrationPhoneNumberAlreadyExist, RegistrationMDPmatch;

	void update(RegisterCustomerDTO dto, Long id) throws RegistrationNoCustomerExist, RegistrationMDPmatch;

}
