package com.example.meucardapioseguro.repositories;

import com.example.meucardapioseguro.model.User;
import com.example.meucardapioseguro.exception.EmailAlreadyExistsException;
import com.example.meucardapioseguro.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<Long, User> userMapById = new HashMap<>();
    private final Map<String, User> userMapByEmail = new HashMap<>();

    public void addUser(User user) {
        if (userMapByEmail.containsKey(user.getEmail())) {
            throw new EmailAlreadyExistsException("Já existe um usuário com este e-mail: " + user.getEmail());
        }
        userMapById.put(user.getId(), user);
        userMapByEmail.put(user.getEmail(), user);
    }

    public User getUserById(Long id) {
        User user = userMapById.get(id);
        if (user == null) {
            throw new UserNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userMapByEmail.get(email);
        if (user == null) {
            throw new UserNotFoundException("Usuário não encontrado com o e-mail: " + email);
        }
        return user;
    }

    public void removeUserById(Long id) {
        User user = userMapById.remove(id);
        if (user != null) {
            userMapByEmail.remove(user.getEmail());
        } else {
            throw new UserNotFoundException("Usuário não encontrado com o ID: " + id);
        }
    }

    public void removeUserByEmail(String email) {
        User user = userMapByEmail.remove(email);
        if (user != null) {
            userMapById.remove(user.getId());
        } else {
            throw new UserNotFoundException("Usuário não encontrado com o e-mail: " + email);
        }
    }

    public void updateUser(User user) {
        if (user == null || user.getId() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Usuário, ID ou e-mail não podem ser nulos.");
        }
        User existingUser = userMapById.get(user.getId());
        if (existingUser != null) {
            if (!existingUser.getEmail().equals(user.getEmail()) && userMapByEmail.containsKey(user.getEmail())) {
                throw new EmailAlreadyExistsException("Não é possível atualizar para um e-mail que já existe: " + user.getEmail());
            }
            userMapByEmail.remove(existingUser.getEmail());
            userMapById.put(user.getId(), user);
            userMapByEmail.put(user.getEmail(), user);
        } else {
            throw new UserNotFoundException("Usuário não encontrado com o ID: " + user.getId());
        }
    }
}
