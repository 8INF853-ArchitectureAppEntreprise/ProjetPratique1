package uqac.groupe6.prixbanque.account.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uqac.groupe6.prixbanque.account.domain.Account;
import uqac.groupe6.prixbanque.customer.persistance.CustomerJpaEntity;

public interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Long> {
	List<AccountJpaEntity> findByCustomer_Id(long idCustomer);

	Account findByIdAndCustomer(long idAccount, CustomerJpaEntity customerJpaEntity);
}
