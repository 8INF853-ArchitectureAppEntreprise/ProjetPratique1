package adapter.encoder;

import org.apache.commons.codec.digest.DigestUtils;

import usecase.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}