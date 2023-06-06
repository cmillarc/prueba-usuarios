package com.example.demo.service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users createUser(Users user) throws UserAlreadyExistsException {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new UserAlreadyExistsException("User already exists with username: " + user.getName());
        }
        return userRepository.save(user);
    }

}
