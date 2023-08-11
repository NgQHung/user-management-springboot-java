package com.example.authentication;

import com.example.authentication.model.State;
import com.example.authentication.model.User;
import com.example.authentication.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;
//@SpringBootTest
public class TestUserRepo {
    @Test
    public void addUser(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Hung", "hung@hung", "0x-asfdjks133", State.PENDING);
        assertThat(user).isNotNull();
        System.out.println("User id: " + user.getId());
        assertThat(user.getId()).isNotBlank();
    }

    @Test
    public void addUserWithPendingState(){
        UserRepo userRepo = new UserRepo();
        User user = userRepo.addUser("Hung", "hung@hung", "0x-asfdjks133", State.PENDING);
        assertThat(user).isNotNull();
        assertThat(user.getId()).isNotBlank();
        assertThat(user.getState()).isEqualTo(State.PENDING);
    }

    @Test
    public void isEmailExist (){
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("hung", "hung@gmail.com", "0x-sdfsdfs23h8");
        userRepo.addUser("Minh Anh", "ma@gmail.com", "0x-sfffsf23");
        userRepo.addUser("Yen Nhi", "yn@gmail.com", "0x-a8u4sdfh0e");
        assertThat(userRepo.isEmailExist("hung@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("huNG@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("ma@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("yn@gmail.com")).isTrue();
        assertThat(userRepo.isEmailExist("ynn@gmail.com")).isFalse();

    }
    @Test
    public void findByEmail() {
        UserRepo userRepo = new UserRepo();
        userRepo.addUser("hung", "hung@gmail.com", "0x-sdfsdfs23h8");
        userRepo.addUser("Minh Anh", "ma@gmail.com", "0x-sfffsf23");
        userRepo.addUser("Yen Nhi", "yn@gmail.com", "0x-a8u4sdfh0e");
        assertThat(userRepo.findByEmail("hung@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("ma@gmail.com")).isPresent();
        assertThat(userRepo.findByEmail("ma1@gmai.com")).isNotPresent();
    }



}
