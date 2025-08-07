package com.api.StudyNookBackend.DTO;

import java.util.Date;

public class UserDTO {
    private String name;
    private String email;
    private String password;

    public UserDTO(){}

    public String getName(){return this.name;}

    public String getEmail(){return this.email;}

    public String getPassword(){return this.password;}
}
