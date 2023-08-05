package com.example.usermanagementrestfullapi.Model.dto.Request;

public record UserRequest( int id, String name, String email, String phone, String avatar, String password) {
}
