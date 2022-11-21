package uqac.groupe6.prixbanque.account.usecase;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uqac.groupe6.prixbanque.account.persistance.AccountJpaEntiry;
import uqac.groupe6.prixbanque.account.persistance.AccountJpaRepository;
import uqac.groupe6.prixbanque.customer.persistance.CustomerJpaEntity;
import uqac.groupe6.prixbanque.customer.persistance.CustomerJpaRepository;

@AllArgsConstructor
@Component
public class AccountGatewayImpl implements AccountGateway {

	private final AccountJpaRepository accountJpaRepository;

	private final CustomerJpaRepository customerJpaRepository;

	@Override
	public void create(Long idCustomer, String accountName) {
		CustomerJpaEntity customerJpaEntity = customerJpaRepository.getById(idCustomer);

		AccountJpaEntiry accountJpaEntiry = new AccountJpaEntiry(customerJpaEntity, accountName, LocalDateTime.now());

		accountJpaRepository.save(accountJpaEntiry);
	}

}
