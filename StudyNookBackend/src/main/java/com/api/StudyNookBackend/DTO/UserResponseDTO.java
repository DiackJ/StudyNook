package com.api.StudyNookBackend.DTO;

import java.time.LocalDateTime;

// dto to return user info upon sign in and sign up without jeopardizing password exposure
// b/c if we use raw UserDTO to return user info, password will return by default since we use it to create password
// and using @JsonIgnore throws a null error
public class UserResponseDTO {
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long id;

    public UserResponseDTO(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){return this.name;}

    public String getEmail(){return this.email;}

    public void setCreatedAt(LocalDateTime createdAt) {this.createdAt = createdAt;}

    public void setEmail(String email) {this.email = email;}

    public LocalDateTime getCreatedAt(){return this.createdAt;}

    public void setId(Long id) {this.id = id;}

    public void setUpdatedAt(LocalDateTime updatedAt) {this.updatedAt = updatedAt;}

    public LocalDateTime getUpdatedAt(){return this.updatedAt;}

    public Long getId(){return this.id;}
}
