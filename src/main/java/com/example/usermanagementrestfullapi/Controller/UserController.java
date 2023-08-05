package com.example.usermanagementrestfullapi.Controller;

import com.example.usermanagementrestfullapi.Entity.User;
import com.example.usermanagementrestfullapi.Model.dto.UserDto;
import com.example.usermanagementrestfullapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam( name = "keyword", required = false, defaultValue = "") String name){
        List<UserDto> users = userService.getSearchUser(name);
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id){
        UserDto user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody User userRequest){

        UserDto user = userService.postUser(userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User userRequest){
        UserDto user = userService.updateUser(id, userRequest);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        UserDto user = userService.deleteUser(id);
        return ResponseEntity.ok().body(user);
    }
}
