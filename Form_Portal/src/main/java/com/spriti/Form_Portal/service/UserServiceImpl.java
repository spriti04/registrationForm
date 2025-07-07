package com.spriti.Form_Portal.service;

import com.spriti.Form_Portal.entity.User;
import com.spriti.Form_Portal.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(User user) {
        String encryptPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptPassword);

        return userRepo.save(user);
    }

    @Override
    public User loggedInUser(String email, String rawPassword) {
        Optional<User> optUser = userRepo.findByEmail(email);

        if(optUser.isEmpty()){
            System.out.println("User with email " + email + "not found!");

        }

        User user = optUser.get();
        passwordEncoder.matches(rawPassword, user.getPassword());

        return user;
    }
}
