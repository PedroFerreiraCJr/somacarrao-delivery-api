package br.com.dotofcodex.somacarrao_delivery.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public final class KeyGeneratorUtil {

	private static Key key;

	private KeyGeneratorUtil() {
		super();
	}

	private static KeyGenerator getKeyGenerator() {
		try {
			return KeyGenerator.getInstance("HmacSHA256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Key getAES() {
		if (key == null) {
			KeyGenerator kg = getKeyGenerator();
			if (kg != null) {
				key = kg.generateKey();
				return key;
			}
		}

		return key;
	}

}
