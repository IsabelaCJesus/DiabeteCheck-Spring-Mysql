package com.example.springDiabetesCheck.repository;

import com.example.springDiabetesCheck.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
