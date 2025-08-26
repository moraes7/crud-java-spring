package com.nicolasmoraes.crud_usuarios.services;

import com.nicolasmoraes.crud_usuarios.infrastructure.entities.User;
import com.nicolasmoraes.crud_usuarios.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);
    }

     public User searchUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado.")
        );
     }

     public void deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
     }

     public void updateUserByID(Long id, User user) {
        User userEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        User userUpdated = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdated);
     }
}
