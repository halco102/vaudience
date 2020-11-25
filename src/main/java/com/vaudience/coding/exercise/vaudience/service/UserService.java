package com.vaudience.coding.exercise.vaudience.service;

import com.vaudience.coding.exercise.vaudience.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();


}
