package com.api.StudyNookBackend.Controller;

import com.api.StudyNookBackend.DTO.UserDTO;
import com.api.StudyNookBackend.DTO.UserResponseDTO;
import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Manager.AccessTokenManager;
import com.api.StudyNookBackend.Repository.UserRepository;
import com.api.StudyNookBackend.Service.UserService;
import com.api.StudyNookBackend.Util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> createNewUser(@RequestBody UserDTO dto, HttpServletResponse httpServletResponse) {
        Matcher matcher = pattern.matcher(dto.getEmail());
        if (!matcher.matches()) {
            throw new RuntimeException("invalid email");
        }
        if (dto.getPassword().length() < 6) {
            throw new RuntimeException("password length needs to be minimum 6 characters");
        }
        User user = userService.createNewUser(dto);

        AccessTokenManager accessTokenManager = new AccessTokenManager(user, jwtUtil);
        accessTokenManager.AddCookieToHeader(httpServletResponse);

        UserResponseDTO userdata = new UserResponseDTO();

        userdata.setCreatedAt(user.getCreatedAt());
        userdata.setId(user.getId());
        userdata.setEmail(user.getEmail());
        userdata.setUpdatedAt(user.getUpdatedAt());
        userdata.setName(user.getName());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userdata);
    }

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody UserDTO dto, HttpServletResponse httpServletResponse) {
        String genericErrorMessage = "Invalid email or password";

        Matcher matcher = pattern.matcher((dto.getEmail()));
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid email");
        }

        if (dto.getPassword().length() < 6) {
            throw new RuntimeException("password length needs to be minimum 6 characters");
        }

        User user = userRepository.findByEmail(dto.getEmail()).orElse(null);

        // if user doesn't exist with the provided email
        if (user == null) {
            throw new RuntimeException(genericErrorMessage);
        }

        // check if the credentials are valid
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
        if (!authentication.isAuthenticated()) {
            throw new RuntimeException(genericErrorMessage);
        }

        // set access token to the cookie header
        AccessTokenManager accessTokenManager = new AccessTokenManager(user, jwtUtil);
        accessTokenManager.AddCookieToHeader(httpServletResponse);

        UserResponseDTO userdata = new UserResponseDTO();

        userdata.setCreatedAt(user.getCreatedAt());
        userdata.setId(user.getId());
        userdata.setEmail(user.getEmail());
        userdata.setUpdatedAt(user.getUpdatedAt());
        userdata.setName(user.getName());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userdata);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("invalid input: " + ex.getMessage());
    }
}
