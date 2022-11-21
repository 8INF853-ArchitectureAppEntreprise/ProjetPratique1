package uqac.groupe6.prixbanque.account.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AccountRequestModel {
	private Long idCustomer;
	private String name;
}
