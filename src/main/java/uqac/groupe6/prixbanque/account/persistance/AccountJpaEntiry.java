package uqac.groupe6.prixbanque.account.persistance;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import uqac.groupe6.prixbanque.customer.persistance.CustomerJpaEntity;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountJpaEntiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	@ManyToOne
	private CustomerJpaEntity idCustomer;

	@NonNull
	private String name;

	@NonNull
	private LocalDateTime createdAt;
}
