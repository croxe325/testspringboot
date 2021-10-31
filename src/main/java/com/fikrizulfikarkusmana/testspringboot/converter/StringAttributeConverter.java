package com.fikrizulfikarkusmana.testspringboot.converter;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.Key;
import java.util.Base64;

public class StringAttributeConverter implements AttributeConverter<String,String> {
    private static final String AES = "AES";
    private static final byte[] encryptKey = "this-is-test-key".getBytes();

    private final Cipher encryptCipher;
    private final Cipher decryptCipher;

    public StringAttributeConverter() throws Exception {
        Key key = new SecretKeySpec(encryptKey, AES);
        encryptCipher = Cipher.getInstance(AES);
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        decryptCipher = Cipher.getInstance(AES);
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    //Proses melakukan encryption
    @Override
    public String convertToDatabaseColumn(String attribute) {
        try {
            return Base64.getEncoder().encodeToString(encryptCipher.doFinal(attribute.getBytes()));
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }


    @Override
    public String convertToEntityAttribute(String dbData) {
        try {
            return new String(decryptCipher.doFinal(Base64.getDecoder().decode(dbData)));
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }
}
