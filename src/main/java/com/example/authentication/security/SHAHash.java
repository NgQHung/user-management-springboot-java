package com.example.authentication.security;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Primary
@Component
public class SHAHash implements Hashing {

    private String salt = "Oshfs-23432rklnsdlfw3i2o4n";
    @Override
    public String hashPassword(String password){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    @Override
    public boolean validatePassword(String originalPassword, String storedPassword) {
        String hashed_pass = hashPassword(originalPassword);
        return storedPassword.equals(hashed_pass);
    }

}
