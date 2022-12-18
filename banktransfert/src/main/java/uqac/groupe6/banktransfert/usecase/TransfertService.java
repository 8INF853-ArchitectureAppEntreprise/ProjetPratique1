package uqac.groupe6.banktransfert.usecase;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uqac.groupe6.bankaccount.domain.Account;
import uqac.groupe6.bankaccount.usecase.AccountGateway;

@Service
@AllArgsConstructor
public class TransfertService implements ITransfertService {

    private final AccountGateway accountGateway;

    @Override
    public void sendVirement(double amount, Long idCustomer, Long idAccount, Long idReceiver, Long idAccountReceiver) {
        Account senderAccount = accountGateway.findByCustomerIdAndAccountId(idCustomer, idAccount);
        Account receiverAccount = accountGateway.findByCustomerIdAndAccountId(idReceiver, idAccountReceiver);

        if (senderAccount.getBalance().getAmount() < amount) {
            throw new RuntimeException("Not enough money");
        }

        senderAccount.getBalance().setAmount(senderAccount.getBalance().getAmount() - amount);
        receiverAccount.getBalance().setAmount(receiverAccount.getBalance().getAmount() + amount);
    }
}
