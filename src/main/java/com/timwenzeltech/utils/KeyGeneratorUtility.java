package com.timwenzeltech.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * KeyGeneratorUtility
 */
public class KeyGeneratorUtility {

    public static KeyPair generateRsaKey() {
        KeyPair keypair;
        try {
            KeyPairGenerator keyPairGenerator = java.security.KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keypair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
        return keypair;
    }
}
