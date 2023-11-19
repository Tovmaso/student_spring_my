package com.example.demo.service;

import com.example.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.models.UserEntity;
@Service
@AllArgsConstructor
public class UserService {
    UserRepo userRepo;
    private BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    public void saveUser(UserEntity userEntity){
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }
}
