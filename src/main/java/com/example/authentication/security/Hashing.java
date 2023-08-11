package com.example.authentication.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface Hashing {
    public String hashPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException;
    public boolean validatePassword(String originalPassword, String storedPassword) throws InvalidKeySpecException, NoSuchAlgorithmException;
}
