package com.example.usermanagementrestfullapi.Service;

import com.example.usermanagementrestfullapi.Entity.User;
import com.example.usermanagementrestfullapi.Exception.NotFoundException;
import com.example.usermanagementrestfullapi.Model.dto.UserDto;
import com.example.usermanagementrestfullapi.Model.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    static {
        users.add(new User("1", "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User("2", "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User("3", "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
        users.add(new User("4", "Hung", "hung@hung.com", "24235234", "avatar.img", "12423njsak"));
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
    public UserDto getUserById(String id) {
//        Optional optional = Optional.empty();
        for (User user: users) {
            if(user.getId() == id ){
//                optional = Optional.of(user);
                return UserMapper.toUserDto(user);
            }
        }
//        return optional;
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

//    @Override
//    public UserDto postUser(UserRequest userRequest) {
//        return null;
//    }

        @Override
    public UserDto postUser(User userRequest) {
        User newUser = new User(userRequest.getId(), userRequest.getName(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getAvatar(), userRequest.getPassword());
        UserDto userDto = UserMapper.toUserDto(newUser);
        users.add(newUser);
        return userDto;
    }

    @Override
    public UserDto updateUser(String id ,User userRequest) {
        User newUser = new User(id, userRequest.getName(), userRequest.getEmail(), userRequest.getPhone(), userRequest.getAvatar(), userRequest.getPassword());
        UserDto userDto = UserMapper.toUserDto(newUser);
//        System.out.println(id);
//        for(User user: users){
//            if(user.getId() == id){
//                return users.set
//            }
//            users.set(users.get(), newUser);
//        }
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getId().equals(id)){
                users.set(i, newUser);

                return userDto;
            }
//            System.out.println(users.get(i).);
        }

//        System.out.println(users);
        return userDto;
    }

}
