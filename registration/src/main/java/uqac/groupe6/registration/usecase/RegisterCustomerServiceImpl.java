package uqac.groupe6.registration.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import uqac.groupe6.registration.domain.User;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class RegisterCustomerServiceImpl implements RegisterCustomerService, UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
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
	public boolean isUserPresent(RegisterCustomerDTO registerCustomerDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	private User dtoToDomain(RegisterCustomerDTO dto) {
		return User.builder().email(dto.getEmail()).firstName(dto.getFirstName()).lastName(dto.getLastName())
				.phoneNumber(dto.getPhoneNumber()).password(bCryptPasswordEncoder.encode(dto.getPassword())).build();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRegisterGateway.findByUsername(username);
	}
}
