package br.com.dotofcodex.somacarrao_delivery.util;

import java.security.Key;
import java.util.Base64;

import javax.crypto.spec.SecretKeySpec;

public class Base64Util {

	public static String encode(Key key) {
		return Base64.getEncoder().encodeToString(key.getEncoded());
	}

	public static Key decode(String source) {
		byte[] bytes = Base64.getDecoder().decode(source);
		return new SecretKeySpec(bytes, 0, bytes.length, "HmacSHA256");
	}
}
