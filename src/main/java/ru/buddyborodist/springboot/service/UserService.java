package ru.buddyborodist.springboot.service;

import ru.buddyborodist.springboot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    void saveUser (User user);

    void deleteUserId(Long id);

    Optional<User> getUserId (Long id);

    void updateUser (User user);

    User getUsername1(String username);
}
