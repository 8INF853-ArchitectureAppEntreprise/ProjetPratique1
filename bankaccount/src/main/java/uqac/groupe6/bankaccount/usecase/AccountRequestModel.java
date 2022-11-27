package uqac.groupe6.bankaccount.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestModel {
	private Long idCustomer;
	private Long idAccount;
	private String name;
}
