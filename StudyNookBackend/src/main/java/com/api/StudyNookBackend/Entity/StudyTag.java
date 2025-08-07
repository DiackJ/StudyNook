package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

@Entity
public class StudyTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many study tags belong to one study set
    @ManyToOne
    @JoinColumn(name = "study_set_id")
    private StudySet studySet;
    //bc many study tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTag;
    private String name;

    public StudyTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public StudySet getStudySet(){return this.studySet;}
    public void setStudySet(StudySet studySet){this.studySet = studySet;}

    public UserTag getUserTag(){return this.userTag;}
    public void setUserTag(UserTag userTag){this.userTag = userTag;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
