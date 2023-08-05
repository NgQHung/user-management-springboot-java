package com.example.usermanagementrestfullapi.Service;

import com.example.usermanagementrestfullapi.Entity.User;
import com.example.usermanagementrestfullapi.Exception.NotFoundException;
import com.example.usermanagementrestfullapi.Model.dto.UserDto;
import com.example.usermanagementrestfullapi.Model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User(1, "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User(2, "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User(3, "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User(4, "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user : users){
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user: users) {
            if(user.getId() == id ){
                return UserMapper.toUserDto(user);
            }
        }
        throw new NotFoundException("This user does not exist in the system");
//        return null;
    }

    @Override
    public List<UserDto> getSearchUser(String keyword) {
        List<UserDto> result = new ArrayList<UserDto>();
        for (User user: users){
            if(user.getName().contains(keyword)){
                result.add(UserMapper.toUserDto(user));
            }
        }
        return result;
    }
}
