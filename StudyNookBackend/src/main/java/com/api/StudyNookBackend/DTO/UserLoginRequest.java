package com.api.StudyNookBackend.DTO;

public class UserLoginRequest {
    private String email;
    private String password;

    public UserLoginRequest(){}

    //DTOs are not entities so they don't need setters for data mapping
    public String getEmail(){return this.email;}
    public String getPassword(){return this.password;}
}
