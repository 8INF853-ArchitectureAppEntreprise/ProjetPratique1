package uqac.groupe6.registration.persistance;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<UserJPAEntity, Long> {
	Optional<UserJPAEntity> findByEmail(String email);

	Optional<UserJPAEntity> findByUsername(String username);
}
