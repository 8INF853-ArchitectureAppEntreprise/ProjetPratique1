package uqac.groupe6.prixbanque.account.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uqac.groupe6.prixbanque.account.domain.Account;
import uqac.groupe6.prixbanque.account.persistance.AccountJpaEntity;
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

		AccountJpaEntity accountJpaEntiry = new AccountJpaEntity(customerJpaEntity, accountName, LocalDateTime.now());

		accountJpaRepository.save(accountJpaEntiry);
	}

	@Override
	public Account getOne(Long idCustomer, Long idAccount) {
		CustomerJpaEntity customerJpaEntity = customerJpaRepository.getById(idCustomer);

		return accountJpaRepository.findByIdAndCustomer(idAccount, customerJpaEntity);
	}

	@Override
	public List<Account> getAll(Long idCustomer) {
		List<Account> toReturn = new ArrayList<>();
		for (AccountJpaEntity accountJpaEntity : accountJpaRepository.findByCustomer_Id(idCustomer)) {
			toReturn.add(jpaToDomain(accountJpaEntity));
		}
		return toReturn;
	}

	private Account jpaToDomain(AccountJpaEntity jpaEntity) {
		return Account.builder().name(jpaEntity.getName()).build();
	}

}
