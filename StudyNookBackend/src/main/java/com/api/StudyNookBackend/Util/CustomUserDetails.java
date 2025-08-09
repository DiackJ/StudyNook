package com.api.StudyNookBackend.Util;

import com.api.StudyNookBackend.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

//define custom user details, implements UserDetails
//this file extracts all the details of the user including credentials and authorities
public class CustomUserDetails implements UserDetails {
    private String username; //aka email. need to use username as default from UserDetails
    private String password;
    private long id;

    public CustomUserDetails(User user){
        this.username = user.getEmail();
        this.password = user.getPassword();
        this.id = user.getId();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public long getId(){
        return id;
    }

    @Override
    public boolean isAccountNonExpired(){return true;}

    @Override
    public boolean isAccountNonLocked(){return true;}

    /*
     @Override
     public boolean isCredentialsNonExpired(){}

     @Override
     public boolean isEnabled(){}
     */
}
