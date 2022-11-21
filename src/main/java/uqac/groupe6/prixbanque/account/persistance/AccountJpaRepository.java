package uqac.groupe6.prixbanque.account.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository extends JpaRepository<AccountJpaEntiry, Long> {

}
