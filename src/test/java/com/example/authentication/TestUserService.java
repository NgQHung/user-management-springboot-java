package com.example.authentication;

import com.example.authentication.exception.UserException;
import com.example.authentication.model.User;
import com.example.authentication.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
public class TestUserService {
    @Autowired private UserService userService;
    @Test
    public void addUser() throws InvalidKeySpecException, NoSuchAlgorithmException {
        User user = userService.addUser("Trinh Minh Cuong", "Hung@gmail.com", "abc12333-");
        assertThat(user).isNotNull();
    }
    @Test
    public void login_when_account_is_pending() throws InvalidKeySpecException, NoSuchAlgorithmException {
        userService.addUser("Trinh Minh Cuong", "Hung@gmail.com", "abc12333-");
        assertThatThrownBy(() -> {
           userService.login("Hung@gmail.com", "abc12333-");
        }).isInstanceOf(UserException.class)
                .hasMessageContaining("User is not activated");
    }

    @Test
    public void login_when_account_is_not_pending() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertThatThrownBy(() -> {
            userService.login("Hung@gmail.com", "abc12333-");
        }).isInstanceOf(UserException.class)
                .hasMessageContaining("User is not activated");
    }
    @Test
    public void login_when_account_is_incorrect() throws InvalidKeySpecException, NoSuchAlgorithmException {
        userService.addUserThenAutoActivate("Trinh Minh Cuong", "MinhAnh@gmail.com", "abc12333+");
        assertThatThrownBy(() -> {
            userService.login("MinhAnh@gmail.com", "abc12333-");
        }).isInstanceOf(UserException.class)
                .hasMessageContaining("Password is incorrect");
    }
    @Test
    public void login_successful() throws InvalidKeySpecException, NoSuchAlgorithmException {
        userService.addUserThenAutoActivate("Trinh Minh Cuong", "MinhAnh@gmail.com", "abc12333+");
        User user = userService.login("MinhAnh@gmail.com","abc12333+");
        System.out.println("user test = " + user);
        assertThat(user).isNotNull();
    }


}
