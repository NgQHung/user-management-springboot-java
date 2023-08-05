package com.example.usermanagementrestfullapi.Service;

import com.example.usermanagementrestfullapi.Entity.User;
import com.example.usermanagementrestfullapi.Model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
public List<UserDto> getListUser();
public UserDto getUserById(String id);
public List<UserDto> getSearchUser(String keyword);

public UserDto postUser(User user);

public UserDto updateUser(String id ,User user);
public UserDto deleteUser(String id);

}
