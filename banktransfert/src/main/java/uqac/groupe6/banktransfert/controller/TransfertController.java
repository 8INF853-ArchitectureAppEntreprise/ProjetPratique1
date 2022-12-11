package uqac.groupe6.banktransfert.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/transfert")
@AllArgsConstructor
public class TransfertController {

	@GetMapping
	public String hello() {
		return "Welcome to Bank Transfert";
	}
}
