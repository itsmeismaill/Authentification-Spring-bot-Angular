package com.example.backend.Repositories;

import com.example.backend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
 @Repository
 public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
