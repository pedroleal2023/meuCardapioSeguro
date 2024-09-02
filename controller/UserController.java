package com.example.meucardapioseguro.controller;

import com.example.meucardapioseguro.model.User;
import com.example.meucardapioseguro.services.UserService;
import com.example.meucardapioseguro.exception.EmailAlreadyExistsException;
import com.example.meucardapioseguro.exception.UserNotFoundException;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean addUser(User user) {
        try {
            return userService.addUser(user);
        } catch (EmailAlreadyExistsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public User getUserById(Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public User getUserByEmail(String email) {
        try {
            return userService.getUserByEmail(email);
        } catch (UserNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    public boolean removeUserById(Long id) {
        try {
            return userService.removeUserById(id);
        } catch (UserNotFoundException | EmailAlreadyExistsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean removeUserByEmail(String email) {
        try {
            return userService.removeUserByEmail(email);
        } catch (UserNotFoundException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean updateUser(User user) {
        try {
            return userService.updateUser(user);
        } catch (EmailAlreadyExistsException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
