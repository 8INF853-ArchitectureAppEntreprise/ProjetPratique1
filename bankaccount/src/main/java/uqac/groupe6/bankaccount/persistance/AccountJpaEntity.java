package uqac.groupe6.bankaccount.persistance;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
