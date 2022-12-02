package uqac.groupe6.bankaccount.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountJpaEntity, Long> {
	List<AccountJpaEntity> findByCustomerId(Long idCustomer);

	Optional<AccountJpaEntity> findByIdAndCustomerId(long idAccount, Long idCustomer);

	Optional<AccountJpaEntity> findByCustomerIdAndName(Long idCustomer, String name);

	List<AccountJpaEntity> findByCustomerIdAndAccountType(Long idCustomer, AccountTypeJPAEnum accountType);
}
