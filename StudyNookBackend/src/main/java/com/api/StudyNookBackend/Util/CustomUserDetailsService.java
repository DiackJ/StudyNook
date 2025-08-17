package com.api.StudyNookBackend.Util;

import com.api.StudyNookBackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.api.StudyNookBackend.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//extract user details, implements UserDetailsService
//here, we implement a service to load a user based on the details we set in our user details file
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired //this annotation is used to grab classes from other parts of our code without needing to declare them as beans
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email).orElseThrow();
        return new CustomUserDetails(user);
    }
}
