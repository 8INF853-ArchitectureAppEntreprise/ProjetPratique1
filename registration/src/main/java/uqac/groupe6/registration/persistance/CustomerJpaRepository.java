package uqac.groupe6.registration.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJPAEntity, Long> {
	Optional<CustomerJPAEntity> findByEmail(String email);
}
