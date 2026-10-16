package com.example.lab2.service;

import com.example.lab2.model.User;
import com.example.lab2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        if (userDetails.getUsername() != null) user.setUsername(userDetails.getUsername());
        if (userDetails.getEmail() != null) user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}