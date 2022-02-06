package com.example.myauthentication.service;

import com.example.myauthentication.domain.User;
import com.example.myauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public Optional<User> findByIdPw(String id) {
        return repository.findById(id);
    }
}
