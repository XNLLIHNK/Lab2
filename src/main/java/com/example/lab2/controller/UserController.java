package com.example.lab2.controller;

import com.example.lab2.model.User;
import com.example.lab2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /api/users (200 OK)
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    // GET /api/users/{id} (200 OK)
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    // POST /api/users (201 Created)
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User created = userService.create(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // PATCH /api/users/{id} (200 OK)
    @PatchMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.update(id, userDetails));
    }

    // DELETE /api/users/{id} (204 No Content)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}