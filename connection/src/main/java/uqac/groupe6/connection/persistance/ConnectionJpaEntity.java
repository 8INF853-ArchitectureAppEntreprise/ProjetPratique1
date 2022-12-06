package uqac.groupe6.connection.persistance;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
