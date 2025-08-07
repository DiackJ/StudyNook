package com.api.StudyNookBackend.DTO;

import com.api.StudyNookBackend.Entity.StudySet;
import com.api.StudyNookBackend.Entity.UserTag;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class StudyTagDTO {
    private String name;

    public StudyTagDTO(){}


    public String getName(){return this.name;}
}
