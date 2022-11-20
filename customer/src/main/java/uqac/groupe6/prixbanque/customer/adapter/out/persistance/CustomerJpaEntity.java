package uqac.groupe6.prixbanque.customer.adapter.out.persistance;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "customer")
class CustomerJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NonNull
	@Column(unique = true)
	private String email;

	@NonNull
	private String password;

	@NonNull
	private LocalDateTime creationTime;

	@NonNull
	private String firstName;

	@NonNull
	private String lastName;

	@NonNull
	private String phoneNumber;

}