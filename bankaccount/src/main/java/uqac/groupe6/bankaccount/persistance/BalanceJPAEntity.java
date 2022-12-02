package uqac.groupe6.bankaccount.persistance;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "balance")
public class BalanceJPAEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	private double ammount;

	@ElementCollection
	@CollectionTable(name = "transaction", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "transactions")
	private List<Integer> transactionList;

	@NonNull
	private LocalDateTime lastUpdate;
}
