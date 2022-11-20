package adapter.repository.requestModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRepositoryDTO {
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
}
