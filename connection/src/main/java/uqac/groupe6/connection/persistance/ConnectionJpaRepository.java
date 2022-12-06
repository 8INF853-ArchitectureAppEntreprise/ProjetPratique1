package uqac.groupe6.connection.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConnectionJpaRepository extends JpaRepository<ConnectionJpaEntity, Long> {
    Optional<ConnectionJpaEntity> findByEmail(String email);

    Optional<ConnectionJpaEntity> findByPhoneNumber(String phoneNumber);
}

