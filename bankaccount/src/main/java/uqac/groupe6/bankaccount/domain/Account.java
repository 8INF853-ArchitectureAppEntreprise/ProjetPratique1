package uqac.groupe6.bankaccount.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Account {
	private String name;

	private AccountType accountType;

	private Balance balance;
}
