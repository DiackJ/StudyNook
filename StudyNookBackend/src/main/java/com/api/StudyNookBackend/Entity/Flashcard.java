package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many flashcards belong to one study set
    @ManyToOne
    @JoinColumn(name = "study_set_id")
    private StudySet studySetId;
    //bc many flashcards belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    private String term;
    private String definition;
    private boolean isCorrect;
    private Date createdAt;
    private Date updatedAt;

    public Flashcard(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public StudySet getStudySetId(){return this.studySetId;}
    public void setStudySetId(StudySet studySetId){this.studySetId = studySetId;}

    public User getUserId(){return this.userId;}
    public void setUserId(User user){this.userId = user;}

    public String getTerm(){return this.term;}
    public void setTerm(String term){this.term = term;}

    public String getDefinition(){return this.definition;}
    public void setDefinition(String def){this.definition = def;}

    public boolean getIsCorrect(){return this.isCorrect;}
    public void setIsCorrect(boolean correct){this.isCorrect = correct;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date date){this.createdAt = date;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date date){this.updatedAt = date;}
}
