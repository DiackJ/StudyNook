package com.api.StudyNookBackend.DTO;

public class EditProfileRequest {
    private String email;
    private String name;

    public EditProfileRequest(){}

    public String getEmail(){return this.email;}
    public String getName(){return this.name;}
}
