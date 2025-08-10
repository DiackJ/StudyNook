package com.api.StudyNookBackend.Service;

import com.api.StudyNookBackend.DTO.UserDTO;
import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Repository.UserRepository;
import com.api.StudyNookBackend.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

//handles all the functionality for the user
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder encoder;

    public UserService(){}

    //create a new user
    public User createNewUser(UserDTO userdto){
        User existingUser = userRepository.findByEmail(userdto.getEmail()).orElseThrow(IllegalArgumentException::new);
        if(userRepository.count() >= 1 && existingUser != null){
            throw new RuntimeException("user already exists");
        }
        User user = new User();
        user.setEmail(userdto.getEmail());
        user.setPassword(encoder.encode(userdto.getPassword()));
        user.setName(userdto.getName());

        return userRepository.save(user);
    }

}
