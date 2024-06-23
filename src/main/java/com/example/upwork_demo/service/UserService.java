package com.example.upwork_demo.service;

import com.example.upwork_demo.model.User;
import com.example.upwork_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveAllUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
