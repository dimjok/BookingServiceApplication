package org.pet.services;

import org.pet.entities.UserEntity;
import org.pet.security.LoginRequest;

import java.util.List;

public interface UserService {
    String login(LoginRequest loginRequest);

    UserEntity register(UserEntity user);

    UserEntity getUserByUsername(String username);

    List<UserEntity> getAllUsers();
}
