package com.example.usermanagementrestfullapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String avatar;
    private String password;
}
