package uqac.groupe6.bankaccount.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uqac.groupe6.registration.persistance.CustomerJpaEntity;

public interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Long> {
	List<AccountJpaEntity> findByCustomer_Id(long idCustomer);

	AccountJpaEntity findByIdAndCustomer(long idAccount, CustomerJpaEntity customerJpaEntity);

	AccountJpaEntity findByCustomer_IdAndByName(CustomerJpaEntity customerJpaEntity, String name);
}
