package com.api.StudyNookBackend.Controller;

import com.api.StudyNookBackend.DTO.UserDTO;
import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Repository.UserRepository;
import com.api.StudyNookBackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//handles endpoint logic for auth
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    private final Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @PostMapping("/signup")
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO dto){
        Matcher matcher = pattern.matcher(dto.getEmail());
        if(!matcher.matches()){
            throw new RuntimeException("invalid email");
        }
        if(dto.getPassword().length() < 6){
            throw new RuntimeException("password length needs to be minimum 6 characters");
        }

        User user = userService.createNewUser(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("invalid input: " + ex.getMessage());
    }
}
