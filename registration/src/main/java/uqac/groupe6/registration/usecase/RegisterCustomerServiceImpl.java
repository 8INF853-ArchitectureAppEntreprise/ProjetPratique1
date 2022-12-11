package uqac.groupe6.registration.usecase;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uqac.groupe6.registration.domain.Customer;
import uqac.groupe6.registration.domain.Role;
import uqac.groupe6.registration.usecase.exception.RegistrationMDPmatch;
import uqac.groupe6.registration.usecase.exception.RegistrationMailAlreadyExist;
import uqac.groupe6.registration.usecase.exception.RegistrationNoCustomerExist;
import uqac.groupe6.registration.usecase.exception.RegistrationPhoneNumberAlreadyExist;

@AllArgsConstructor
@Service
public class RegisterCustomerServiceImpl implements RegisterCustomerService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	private CustomerRegisterGateway customerRegisterGateway;

	@Override
	public void register(RegisterCustomerDTO dto)
			throws RegistrationMailAlreadyExist, RegistrationPhoneNumberAlreadyExist, RegistrationMDPmatch {
		if (!dto.getNewPassword().equals(dto.getPassword())) {
			throw new RegistrationMDPmatch("Password don't match");

		} else if (customerRegisterGateway.existsByEmail(dto.getEmail())) {
			throw new RegistrationMailAlreadyExist("Account with email " + dto.getEmail() + " already exist");
		} else if (customerRegisterGateway.existsByPhoneNumber(dto.getPhoneNumber())) {
			throw new RegistrationPhoneNumberAlreadyExist(
					"Account with phone number " + dto.getPhoneNumber() + " already exist");
		}

		customerRegisterGateway.save(dtoToDomain(dto));
	}

	@Override
	public void update(RegisterCustomerDTO dto, Long id) throws RegistrationNoCustomerExist, RegistrationMDPmatch {
		if (!customerRegisterGateway.existsById(id)) {
			throw new RegistrationNoCustomerExist("No customer exist for this id");
		}

		if (!customerRegisterGateway.pwdMatchBdd(dto.getPassword(), id)) {
			throw new RegistrationMDPmatch("Password don't match");
		}

		customerRegisterGateway.update(dto, id);

	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRegisterGateway.findByEmail(email);

		// Conversion d'un customer en UserDetail
		User user = new User(customer.getEmail(), customer.getPassword(),
				Collections.singletonList(new SimpleGrantedAuthority(customer.getRole().name())));

		return user;
	}

	private Customer dtoToDomain(RegisterCustomerDTO dto) {
		return Customer.builder().email(dto.getEmail()).firstName(dto.getFirstName()).lastName(dto.getLastName())
				.phoneNumber(dto.getPhoneNumber()).password(encoder.encode(dto.getPassword())).role(Role.USER).build();
	}
}
