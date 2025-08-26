package com.nicolasmoraes.crud_usuarios.infrastructure.repository;

import com.nicolasmoraes.crud_usuarios.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
