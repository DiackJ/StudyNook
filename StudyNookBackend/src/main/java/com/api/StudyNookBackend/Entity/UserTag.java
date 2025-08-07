package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//responsible for holding all tags created across platform
@Entity
public class UserTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdByUser;
    private Date createdAt;
    private Date updatedAt;
    //holds all the tags created in task feature
    @OneToMany(mappedBy = "user_tag")
    private List<TaskTag> allTaskTags;
    //holds all the tags created in quiz/study set feature
    @OneToMany(mappedBy = "user_tag")
    private List<StudyTag> allStudyTags;
    //holds all the tags created in note-taking feature
    @OneToMany(mappedBy = "user_tag")
    private List<NoteTag> allNoteTags;

    //class constructor to create objects
    //need to initiate all lists as specified list type
    public UserTag(){
        this.allTaskTags = new ArrayList<>();
        this.allNoteTags = new ArrayList<>();
        this.allStudyTags = new ArrayList<>();
    }

    //getters and setters for all fields for proper data mapping
    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public User getCreatedByUser(){return this.createdByUser;}
    public void setCreatedByUser(User createdByUser){this.createdByUser = createdByUser;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date createdAt){this.createdAt = createdAt;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date updatedAt){this.updatedAt = updatedAt;}

    public List<TaskTag> getAllTaskTags(){return this.allTaskTags;}
    public void setAllTaskTags(List<TaskTag> taskTags){this.allTaskTags = taskTags;}

    public List<StudyTag> getAllStudyTags(){return this.allStudyTags;}
    public void setAllStudyTags(List<StudyTag> studyTags){this.allStudyTags = studyTags;}

    public List<NoteTag> getAllNoteTags(){return this.allNoteTags;}
    public void setAllNoteTags(List<NoteTag> noteTags){this.allNoteTags = noteTags;} 
}
