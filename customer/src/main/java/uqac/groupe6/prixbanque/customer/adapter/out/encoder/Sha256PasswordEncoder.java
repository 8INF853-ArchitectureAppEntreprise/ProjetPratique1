package uqac.groupe6.prixbanque.customer.adapter.out.encoder;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import uqac.groupe6.prixbanque.customer.usecase.port.out.PasswordEncoder;

@Service
public class Sha256PasswordEncoder implements PasswordEncoder {
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}