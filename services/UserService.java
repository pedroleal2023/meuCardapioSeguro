package com.example.meucardapioseguro.services;

import com.example.meucardapioseguro.model.User;
import com.example.meucardapioseguro.exception.EmailAlreadyExistsException;
import com.example.meucardapioseguro.exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private final List<User> users;
    private final Map<Long, User> userMapById;
    private final Map<String, User> userMapByEmail;

    public UserService() {
        this.users = new ArrayList<>();
        this.userMapById = new HashMap<>();
        this.userMapByEmail = new HashMap<>();
    }

    // Adiciona um novo usuário
    public synchronized boolean addUser(User user) {
        if (user == null || user.getEmail() == null || user.getId() == null) {
            throw new IllegalArgumentException("Usuário, ID ou e-mail não podem ser nulos.");
        }
        if (userMapByEmail.containsKey(user.getEmail())) {
            throw new EmailAlreadyExistsException("Já existe um usuário com este e-mail: " + user.getEmail());
        }
        users.add(user);
        userMapById.put(user.getId(), user);
        userMapByEmail.put(user.getEmail(), user);
        return true;
    }

    // Obtém um usuário por ID
    public synchronized User getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        User user = userMapById.get(id);
        if (user == null) {
            throw new UserNotFoundException("Usuário não encontrado com o ID: " + id);
        }
        return user;
    }

    // Obtém um usuário por e-mail
    public synchronized User getUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("E-mail não pode ser nulo.");
        }
        User user = userMapByEmail.get(email);
        if (user == null) {
            throw new UserNotFoundException("Usuário não encontrado com o e-mail: " + email);
        }
        return user;
    }

    // Lista todos os usuários
    public synchronized List<User> getAllUsers() {
        return Collections.unmodifiableList(new ArrayList<>(users));
    }

    // Remove um usuário por ID
    public synchronized boolean removeUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        User user = userMapById.get(id);
        if (user != null) {
            users.remove(user);
            userMapById.remove(id);
            userMapByEmail.remove(user.getEmail());
            return true;
        }
        return false;
    }

    // Remove um usuário por e-mail
    public synchronized boolean removeUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("E-mail não pode ser nulo.");
        }
        User user = userMapByEmail.get(email);
        if (user != null) {
            users.remove(user);
            userMapById.remove(user.getId());
            userMapByEmail.remove(email);
            return true;
        }
        return false;
    }

    // Atualiza informações de um usuário
    public synchronized boolean updateUser(User user) {
        if (user == null || user.getId() == null || user.getEmail() == null) {
            throw new IllegalArgumentException("Usuário, ID ou e-mail não podem ser nulos.");
        }
        User existingUser = userMapById.get(user.getId());
        if (existingUser != null) {
            // Verifica se o e-mail está sendo alterado e se o novo e-mail já existe para outro usuário
            if (!existingUser.getEmail().equals(user.getEmail()) && userMapByEmail.containsKey(user.getEmail())) {
                throw new EmailAlreadyExistsException("Não é possível atualizar para um e-mail que já existe: " + user.getEmail());
            }
            userMapByEmail.remove(existingUser.getEmail());
            userMapById.put(user.getId(), user);
            userMapByEmail.put(user.getEmail(), user);
            return true;
        }
        return false;
    }
}
