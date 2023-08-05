package com.example.usermanagementrestfullapi.Model.mapper;

import com.example.usermanagementrestfullapi.Entity.User;
import com.example.usermanagementrestfullapi.Model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user){
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setEmail(user.getEmail());
        tmp.setPhone(user.getPhone());
        tmp.setAvatar(user.getAvatar());
        return tmp;
    }

}
