package com.example.springapp.controller;

import com.example.springapp.model.User;
import com.example.springapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return service.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return ResponseEntity.ok(service.updateUser(user));
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // JPQL usage: find user by username
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = service.getUserByUsername(username);
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    // JPQL usage: find user by email
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = service.getUserByEmail(email);
        return user.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/page")
public Page<User> getPaginatedUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size
) {
    Pageable pageable = PageRequest.of(page, size);
    return service.getPaginatedUsers(pageable);
}
    
}
