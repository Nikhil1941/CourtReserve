package com.example.springapp.service;

import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    // JPQL: Find user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    // JPQL: Find user by email
    public Optional<User> getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    // Save new user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // Update user
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
    public Page<User> getPaginatedUsers(Pageable pageable) {
    return userRepo.findAll(pageable);
}
}
