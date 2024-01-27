package com.sipl.vehicle.manager.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class EncryptionUtil {

	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = "1234567891234567".getBytes();

	//generate key for encryption
	public static Key getKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	};

	//encrypt password
	public static String encryptPassword(String valueToEnc, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encValue = cipher.doFinal(valueToEnc.getBytes());
		byte[] encryptedByteValue = new Base64().encode(encValue);
		System.out.println("Encrypted Value :: " + new String(encryptedByteValue));

		return new String(encryptedByteValue);
	}

	//decrypt passsword
	public static String decryptPassword(String encryptedValue, Key key) throws Exception {
		// Key key = generateKey();
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decodedBytes = new Base64().decode(encryptedValue.getBytes());

		byte[] enctVal = cipher.doFinal(decodedBytes);

		System.out.println("Decrypted Value :: " + new String(enctVal));
		return new String(enctVal);
	}

}
