package com.example.springDiabetesCheck.repository;
import com.example.springDiabetesCheck.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
