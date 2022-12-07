package uqac.groupe6.connection.persistance;

import java.time.LocalDateTime;

import javax.persistence.*;

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
@Table(name = "customer")
public class ConnectionJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
