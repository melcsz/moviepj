package com.example.moviepj.service;

import com.example.moviepj.csv.Parser;
import com.example.moviepj.persistance.repository.UserRepository;
import com.example.moviepj.persistance.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<UserEntity> listOfUsers = Parser.csvToUserEntity(file.getInputStream());
            for (UserEntity users : listOfUsers) {
                if (!(userRepository.existsByEmail(users.getEmail()))) {
                    userRepository.save(users);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }
}
