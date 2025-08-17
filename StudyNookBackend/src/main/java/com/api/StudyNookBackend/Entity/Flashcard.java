package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Flashcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many flashcards belong to one study set
    @ManyToOne
    @JoinColumn(name = "study_set_id")
    private StudySet studySet;
    //bc many flashcards belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String term;
    private String definition;
    private boolean isCorrect;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Flashcard(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public StudySet getStudySetId(){return this.studySet;}
    public void setStudySetId(StudySet studySetId){this.studySet = studySetId;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public String getTerm(){return this.term;}
    public void setTerm(String term){this.term = term;}

    public String getDefinition(){return this.definition;}
    public void setDefinition(String def){this.definition = def;}

    public boolean getIsCorrect(){return this.isCorrect;}
    public void setIsCorrect(boolean correct){this.isCorrect = correct;}

    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(LocalDateTime date){this.createdAt = date;}

    public LocalDateTime getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime date){this.updatedAt = date;}
}
