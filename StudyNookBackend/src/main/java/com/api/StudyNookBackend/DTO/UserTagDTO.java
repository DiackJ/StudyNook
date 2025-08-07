package com.api.StudyNookBackend.DTO;

import com.api.StudyNookBackend.Entity.NoteTag;
import com.api.StudyNookBackend.Entity.StudyTag;
import com.api.StudyNookBackend.Entity.TaskTag;
import com.api.StudyNookBackend.Entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTagDTO {
    private long id;
    private User createdByUser;
    private Date createdAt;
    private Date updatedAt;

    //class constructor to create objects
    public UserTagDTO(){}

    //getters and setters for all fields for proper data mapping
    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public User getCreatedByUser(){return this.createdByUser;}
    public void setCreatedByUser(User createdByUser){this.createdByUser = createdByUser;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date createdAt){this.createdAt = createdAt;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date updatedAt){this.updatedAt = updatedAt;}
}
