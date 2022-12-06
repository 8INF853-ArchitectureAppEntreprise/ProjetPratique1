package uqac.groupe6.connection.usecase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ConnectionRequestModel {
    private String email;
    private String password;
    private String phoneNumber;
}
