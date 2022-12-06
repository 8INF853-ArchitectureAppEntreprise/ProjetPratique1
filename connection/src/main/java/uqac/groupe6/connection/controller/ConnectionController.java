package uqac.groupe6.connection.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uqac.groupe6.connection.domain.User;
import uqac.groupe6.connection.usecase.ConnectionCustomService;
import uqac.groupe6.connection.usecase.ConnectionRequestModel;
import uqac.groupe6.connection.usecase.exception.ConnectionNoID;
import uqac.groupe6.connection.usecase.exception.ConnectionNoUser;
import uqac.groupe6.connection.usecase.exception.ConnectionPasswordWrong;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor

public class ConnectionController {

    private final ConnectionCustomService customerService;
    @PostMapping("/login")
    ResponseEntity login(@RequestBody ConnectionRequestModel requestModel) {


        User user = null;
        try {
            user = customerService.login(requestModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());
        } catch (ConnectionNoID | ConnectionNoUser | ConnectionPasswordWrong e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @GetMapping
    public String mainPage() {
        return "main page customer";
    }

}
