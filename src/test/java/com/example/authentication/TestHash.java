package com.example.authentication;

import com.example.authentication.security.Hashing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class TestHash {
    @Autowired private Hashing hash;
    @Test
    public void hashPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        var passwords = List.of("abc", "qwert", "ox-123", "_&?sldkfalLsdhf89");
        for (String password: passwords){
            String hashed_pass = hash.hashPassword(password);
            assertThat(hashed_pass).isNotNull();
        }
    }

    @Test void validatePassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        var passwords = List.of("abc", "qwert", "ox-123", "_&?sldkfalLsdhf89");
        for (String password: passwords){
            String hashed_pass = hash.hashPassword(password);
            System.out.println("hashed_pass" + hashed_pass);
            System.out.println("password" + password);
            assertThat(hash.validatePassword(password, hashed_pass)).isTrue();
        }
//        assertThat(hash.validatePassword("abc", "1000:a03a2f878b27e2c6f16f412f17deb19b:f3defca0c43205f3bba9465f291662b6a8a0008a9d5945025049f99035e45925ff496ad09124380bf12fc8f86a8014c18708c46047cb7ef83ad9e87e0e29f44a")).isFalse();
    }


}
