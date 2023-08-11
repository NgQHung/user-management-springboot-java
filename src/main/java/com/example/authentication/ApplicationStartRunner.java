package com.example.authentication;

import com.example.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements ApplicationRunner {
    @Autowired UserService userService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.addUserThenAutoActivate("Admin", "admin@hung.hung", "abc123");
        userService.addUser("John", "john@hung.hung", "123456");
    }
}
