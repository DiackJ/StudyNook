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
    private StudySet studySetId;
    //bc many study tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTagId;
    private String name;

    public StudyTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public StudySet getStudySetId(){return this.studySetId;}
    public void setStudySetId(StudySet studySetId){this.studySetId = studySetId;}

    public UserTag getUserTagId(){return this.userTagId;}
    public void setUserTagId(UserTag userTagId){this.userTagId = userTagId;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
