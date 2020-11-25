package com.vaudience.coding.exercise.vaudience.service.implementation;

import com.vaudience.coding.exercise.vaudience.domain.User;
import com.vaudience.coding.exercise.vaudience.dto.UserDto;
import com.vaudience.coding.exercise.vaudience.mapper.UserMapper;
import com.vaudience.coding.exercise.vaudience.repositories.UserRepository;
import com.vaudience.coding.exercise.vaudience.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserByUsername(String username) {
        User tempUser = userRepository.findUserByUsername(username);
        UserDto userDto = userMapper.toDto(tempUser);

        return userDto;
    }

    @Override
    public ResponseEntity<Void> addNewUser(UserDto userDto) {
        User newUser = this.userMapper.toEntity(userDto);
        this.userRepository.save(newUser);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
