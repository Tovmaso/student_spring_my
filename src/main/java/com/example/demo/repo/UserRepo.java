package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.UserEntity;

import java.util.Optional;


public interface UserRepo extends CrudRepository<UserEntity,Long> {
    public Optional<UserEntity> findByEmail (String email);
}
