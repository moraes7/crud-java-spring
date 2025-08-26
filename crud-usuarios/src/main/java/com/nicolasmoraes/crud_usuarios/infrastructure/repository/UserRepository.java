package com.nicolasmoraes.crud_usuarios.infrastructure.repository;

import com.nicolasmoraes.crud_usuarios.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
