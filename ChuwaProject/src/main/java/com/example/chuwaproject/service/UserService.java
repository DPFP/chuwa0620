package com.example.chuwaproject.service;

import com.example.chuwaproject.bean.User;
import com.example.chuwaproject.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserDao userDao;
    @Autowired
    public UserService(UserDao userDao){this.userDao = userDao;}

    public Optional<User> getUser(long id){
        return userDao.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userDao.findByEmail(email);
    }

    public User saveUser(User user){
        return userDao.save(user);
    }

    public void deleteUserById(Long id) {
        userDao.deleteById(id);
    }
}
