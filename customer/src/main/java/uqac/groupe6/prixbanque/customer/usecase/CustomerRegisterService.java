package uqac.groupe6.prixbanque.customer.usecase;

import uqac.groupe6.prixbanque.customer.usecase.port.in.requestModel.CustomerRequestModel;

public interface CustomerRegisterService {

	CustomerResponseModel register(final CustomerRequestModel customer);
}
