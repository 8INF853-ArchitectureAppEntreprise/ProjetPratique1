package uqac.groupe6.bankaccount.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.domain.AccountType;
import uqac.groupe6.bankaccount.domain.Balance;
import uqac.groupe6.bankaccount.persistance.AccountJpaEntity;
import uqac.groupe6.bankaccount.persistance.AccountJpaRepository;
import uqac.groupe6.bankaccount.persistance.AccountTypeJPAEnum;
import uqac.groupe6.bankaccount.persistance.BalanceJPAEntity;

@AllArgsConstructor
@Component
public class AccountGatewayImpl implements AccountGateway {

	private final AccountJpaRepository accountJpaRepository;

	@Override
	public void create(Long idCustomer, String accountName, AccountType accountType) {
		accountJpaRepository.save(new AccountJpaEntity(idCustomer, accountName, LocalDateTime.now(),
				new BalanceJPAEntity(0.0, LocalDateTime.now()), AccountTypeJPAEnum.valueOf(accountType.name())));
	}

	@Override
	public void updateName(Long accountId, String newAccountName) {
		accountJpaRepository.findById(accountId).map(jpaAccount -> {
			jpaAccount.setName(newAccountName);
			accountJpaRepository.save(jpaAccount);
			return null;
		});
	}

	@Override
	public void delete(Long idAccount) {
		accountJpaRepository.deleteById(idAccount);
	}

	@Override
	public Account findByAccountId(Long idAccount) {
		return accountJpaRepository.findById(idAccount).map(jpaAccount -> {
			return Account.builder().name(jpaAccount.getName()).build();
		}).orElse(null);
	}

	@Override
	public Account findByCustomerIdAndAccountId(Long idCustomer, Long idAccount) {
		return accountJpaRepository.findByIdAndCustomerId(idAccount, idCustomer).map(jpaAccount -> {
			return Account.builder().name(jpaAccount.getName()).build();
		}).orElse(null);
	}

	@Override
	public List<Account> findAllAccounts(Long idCustomer) {
		List<Account> toReturn = new ArrayList<>();
		for (AccountJpaEntity accountJpaEntity : accountJpaRepository.findByCustomerId(idCustomer)) {
			toReturn.add(accountJpaToDomain(accountJpaEntity));
		}
		return toReturn;
	}

	@Override
	public Account findByCustomerIdAndByName(Long idCustomer, String name) {
		return accountJpaRepository.findByCustomerIdAndName(idCustomer, name).map(jpaAccount -> {
			return Account.builder().name(jpaAccount.getName()).build();
		}).orElse(null);
	}

	@Override
	public List<Account> findByCustomerIdAndAccountType(Long customerId, AccountType accountType) {
		List<Account> toReturn = new ArrayList<>();
		for (AccountJpaEntity accountJpaRepository : accountJpaRepository.findByCustomerIdAndAccountType(customerId,
				AccountTypeJPAEnum.valueOf(accountType.name()))) {
			toReturn.add(accountJpaToDomain(accountJpaRepository));
		}
		return toReturn;
	}

	private Account accountJpaToDomain(AccountJpaEntity jpaEntity) {
		return Account.builder().name(jpaEntity.getName())
				.accountType(AccountType.valueOf(jpaEntity.getAccountType().name()))
				.balance(balanceJpaToDomain(jpaEntity.getBalanceJPAEntity())).build();
	}

	private Balance balanceJpaToDomain(BalanceJPAEntity jpaEntity) {
		return Balance.builder().amount(jpaEntity.getAmount()).build();
	}
}
