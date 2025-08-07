package com.api.StudyNookBackend.DTO;

import java.util.Date;

public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String password;
    private Date createdAt;
    private Date updatedAt;



    public UserDTO(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date createdAt){this.createdAt = createdAt;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date updatedAt){this.updatedAt = updatedAt;}
}
