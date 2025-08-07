package com.api.StudyNookBackend.DTO;

import com.api.StudyNookBackend.Entity.User;

import java.util.Date;

public class UserTagDTO {
    private User createdByUser;
    private Date createdAt;
    private Date updatedAt;

    //class constructor to create objects
    public UserTagDTO(){}

    public User getCreatedByUser(){return this.createdByUser;}

    public Date getCreatedAt(){return this.createdAt;}

    public Date getUpdatedAt(){return this.updatedAt;}
}
