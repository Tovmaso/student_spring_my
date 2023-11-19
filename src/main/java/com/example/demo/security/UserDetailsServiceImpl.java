package com.example.demo.security;


import com.example.demo.models.UserEntity;
import com.example.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepo userRepo;
    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Пользователь с таким Email '"+username+"' не найден"));
        return UserDetailsImpl.build(userEntity);

    }
}
