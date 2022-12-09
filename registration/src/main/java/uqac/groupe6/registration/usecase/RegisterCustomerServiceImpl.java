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

@AllArgsConstructor
@Service
public class RegisterCustomerServiceImpl implements RegisterCustomerService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	private CustomerRegisterGateway customerRegisterGateway;

	@Override
	public void register(RegisterCustomerDTO registerCustomerDTO) {
		// Vérifier que les mots de passe sont identique
		if (!registerCustomerDTO.getPassword().equals(registerCustomerDTO.getMatchedPassword())) {
			// Lever une exception
		}
		customerRegisterGateway.save(dtoToDomain(registerCustomerDTO));
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
