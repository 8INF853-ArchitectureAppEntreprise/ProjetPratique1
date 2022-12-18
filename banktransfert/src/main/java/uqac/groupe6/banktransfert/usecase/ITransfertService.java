package uqac.groupe6.banktransfert.usecase;

public interface ITransfertService {

    void sendVirement(double amount, Long idCustomer, Long idAccount, Long idReceiver, Long idAccountReceiver);
}

