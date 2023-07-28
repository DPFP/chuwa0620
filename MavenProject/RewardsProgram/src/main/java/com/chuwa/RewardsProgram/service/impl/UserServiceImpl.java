package com.chuwa.RewardsProgram.service.impl;

import com.chuwa.RewardsProgram.dao.UserRepository;
import com.chuwa.RewardsProgram.entity.User;
import com.chuwa.RewardsProgram.expection.ResourceNotFoundException;
import com.chuwa.RewardsProgram.payload.UserDto;
import com.chuwa.RewardsProgram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
//        return null;
        User user = mapToEntity(userDto);
        User newUser = userRepository.save(user);

        UserDto userResponse = mapToDto(newUser);
        return userResponse;
    }

    @Override
    public List<UserDto> getAllUsers() {
//        return null;
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
//        return null;
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return mapToDto(user);
    }

    @Override
    public void deleteUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }

    private UserDto mapToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());

        return userDto;
    }

    private User mapToEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());

        return user;
    }
}
