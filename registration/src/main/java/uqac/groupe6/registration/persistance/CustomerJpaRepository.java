package uqac.groupe6.registration.persistance;

import java.util.Optional;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerJpaEntity, Long> {
	Optional<CustomerJpaEntity> findByEmail(String email);

	Optional<CustomerJpaEntity> findByPhoneNumber(String phoneNumber);

	Optional<CustomerJpaEntity> findById(Long idCustomer);
}
