package uqac.groupe6.connection.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uqac.groupe6.connection.usecase.ConnectionRequestModel;

@RestController
@RequestMapping("/customer")
@AllArgsConstructor

public class ConnectionController {

    @PostMapping("/connection")
    ResponseEntity create(@RequestBody ConnectionRequestModel requestModel) {
        if(requestModel.getEmail() == null && requestModel.getPhoneNumber() == null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Pas d'email");

        }
        if(requestModel.getPassword() == null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Pas de mdp");

        }
        if(requestModel.getPhoneNumber() == null){
            return ResponseEntity.status(HttpStatus.CREATED).body("Pas de tel");

        }
       // try {
       //     customerService.register(requestModel);
       // } catch (RegistrationMailAlreadyExist | RegistrationPhoneNumberAlreadyExist e) {
       //     return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
       // }
        return ResponseEntity.status(HttpStatus.CREATED).body("New account created");

    }

    @GetMapping
    public String mainPage() {
        return "main page customer";
    }

}
