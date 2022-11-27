package uqac.groupe6.bankaccount.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.persistance.AccountJpaEntity;
import uqac.groupe6.bankaccount.persistance.AccountJpaRepository;
import uqac.groupe6.registration.persistance.CustomerJpaEntity;
import uqac.groupe6.registration.persistance.CustomerJpaRepository;

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

		return null;
		// return accountJpaRepository.findByIdAndCustomer(idAccount,
		// customerJpaEntity);
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

	@Override
	public Account findByCustomer_IdAndByName(Long idCustomer, String name) {
		CustomerJpaEntity customerJpaEntity = customerJpaRepository.getById(idCustomer);

		AccountJpaEntity toReturn = accountJpaRepository.findByCustomer_IdAndByName(customerJpaEntity, name);

		return Account.builder().name(toReturn.getName()).build();
	}

}
