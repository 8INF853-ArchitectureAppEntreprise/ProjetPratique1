package uqac.groupe6.account.usecase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AccountResponseModel {
	private String name;
}
