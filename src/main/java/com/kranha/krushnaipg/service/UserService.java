package com.kranha.krushnaipg.service;

import com.kranha.krushnaipg.dto.User;
import com.kranha.krushnaipg.repository.jpa.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User saveUser(User user) {
        return repo.save(user);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public List<User> getUserByEmail(String email) {

        return repo.findByEmail(email);

    }

    public List<User> getUserByAsnID() {
        return repo.orderByID();
    }

    public List<User> getUserByDsc() {
        return repo.orderByName();
    }

    public List<User> getUserByEndingLetter(String letter){
        return repo.findByNameEndingWith(letter);
    }
}

