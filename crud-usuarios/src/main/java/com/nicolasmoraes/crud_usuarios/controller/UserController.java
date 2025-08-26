package com.nicolasmoraes.crud_usuarios.controller;

import com.nicolasmoraes.crud_usuarios.infrastructure.entities.User;
import com.nicolasmoraes.crud_usuarios.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<User> searchUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.searchUserByEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserByEmail(@RequestParam String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updatedUserByID(@RequestParam Long id, @RequestBody User user) {
        userService.updateUserByID(id, user);
        return ResponseEntity.ok().build();
    }

}
