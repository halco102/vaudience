package com.vaudience.coding.exercise.vaudience.controller;

import com.vaudience.coding.exercise.vaudience.dto.UserDto;
import com.vaudience.coding.exercise.vaudience.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<List<UserDto>>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<UserDto> findUserByUsername(@PathVariable String username){
            return new ResponseEntity<UserDto>(userService.findUserByUsername(username),HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Void> addNewUser(@RequestBody UserDto userDto){
       return this.userService.addNewUser(userDto);
    }

}
