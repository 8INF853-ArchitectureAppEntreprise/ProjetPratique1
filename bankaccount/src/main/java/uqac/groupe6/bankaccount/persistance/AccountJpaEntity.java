package uqac.groupe6.bankaccount.persistance;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class AccountJpaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	private Long customerId;

	@NonNull
	private String name;

	@NonNull
	private LocalDateTime createdAt;

	@OneToOne(cascade = { CascadeType.ALL })
	@NonNull
	private BalanceJPAEntity balanceJPAEntity;

	@Enumerated(EnumType.STRING)
	@NonNull
	private AccountTypeJPAEnum accountType;
}
