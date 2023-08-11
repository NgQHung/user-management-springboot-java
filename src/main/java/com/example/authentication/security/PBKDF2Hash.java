package com.example.authentication.security;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//@Primary
@Component
public class PBKDF2Hash implements Hashing {
    @Override
    public String hashPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt;
        try{
            salt = getSalt();
        }catch(NoSuchAlgorithmException e) {
            return null;
        }

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf;
        try{
            skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        }catch(NoSuchAlgorithmException e){
            return null;
        }

        byte[] hash = skf.generateSecret(spec).getEncoded();

        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);

        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    @Override
    public boolean validatePassword(String originalPassword, String storedPassword) throws InvalidKeySpecException, NoSuchAlgorithmException {
        String hashed_pass = hashPassword(originalPassword);
        return storedPassword.equals(hashed_pass);
    }
}
