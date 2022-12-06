package uqac.groupe6.connection.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;


}
