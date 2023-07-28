package com.chuwa.RewardsProgram.service;

import com.chuwa.RewardsProgram.payload.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(long id);
    void deleteUserById(long id);
}
