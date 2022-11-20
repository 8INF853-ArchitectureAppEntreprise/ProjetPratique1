package domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer {

	private long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private Account Account;
}
