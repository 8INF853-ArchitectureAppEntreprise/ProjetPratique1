package uqac.groupe6.banktransfert.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uqac.groupe6.banktransfert.usecase.ITransfertService;

@RestController
@RequestMapping("/transfert")
@AllArgsConstructor
public class TransfertController {

	private final ITransfertService transfertService;

	@GetMapping("/{amount}/from/{idCustomer}/{idAccount}/to/{idReceiver}/{idAccountReceiver}")
	public ResponseEntity sendVirement(@PathVariable double amount, @PathVariable Long idCustomer, @PathVariable Long idAccount, @PathVariable Long idReceiver, @PathVariable Long idAccountReceiver) {
		try {
			transfertService.sendVirement(amount, idCustomer, idAccount, idReceiver, idAccountReceiver);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Virement sent");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}
}
