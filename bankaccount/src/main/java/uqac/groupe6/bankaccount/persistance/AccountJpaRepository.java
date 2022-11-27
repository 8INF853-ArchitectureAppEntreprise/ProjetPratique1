package uqac.groupe6.bankaccount.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uqac.groupe6.registration.persistance.CustomerJpaEntity;

public interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Long> {
	List<AccountJpaEntity> findByCustomer_Id(long idCustomer);

	Optional<AccountJpaEntity> findByIdAndCustomer(long idAccount, CustomerJpaEntity customerJpaEntity);

	Optional<AccountJpaEntity> findByCustomerAndName(CustomerJpaEntity customerJpaEntity, String name);
}
