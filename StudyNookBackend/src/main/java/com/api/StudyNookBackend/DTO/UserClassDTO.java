package com.api.StudyNookBackend.DTO;

import com.api.StudyNookBackend.Entity.User;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class UserClassDTO {
    private String name;
    private Long id;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;

    public UserClassDTO(){}

    public String getName(){return this.name;}
    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}
    public Long getUserId(){return this.userId;}
    public void setUserId(Long user){this.userId = user;}
    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(LocalDateTime date){this.createdAt = date;}
    public LocalDateTime getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime date){this.updatedAt = date;}
    public boolean getIsActive(){return this.isActive;}
    public void setIsActive(boolean active){this.isActive = active;}
}
