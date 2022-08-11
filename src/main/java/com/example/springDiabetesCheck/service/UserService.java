package com.example.springDiabetesCheck.service;

import com.example.springDiabetesCheck.domain.Role;
import com.example.springDiabetesCheck.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRouleToUser(String username, String rouleName);
    User getUser(String username);
    List<User> getUsers();
    void deleteUser(Long id);
    User updateUserById(String name, Long id);
}
