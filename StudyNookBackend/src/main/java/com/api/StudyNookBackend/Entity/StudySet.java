package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class StudySet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc one class can have many study sets
    @ManyToOne
    @JoinColumn(name = "user_class")
    private UserClass userClass; //please use "userClass" since "class" is a Java keyword. it WILL cause errors!
    //bc one user will have many study sets
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //bc one study set will have many flashcards
    @OneToMany(mappedBy = "studySet")
    private List<Flashcard> allFlashcards;
    //bc one study set will have many study tags
    @OneToMany(mappedBy = "studySet")
    private List<StudyTag> allStudyTags;
    private String title;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //no args constructor but need to define type of list
    public StudySet(){
        this.allStudyTags = new ArrayList<>();
        this.allFlashcards = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public UserClass getUserClass(){return this.userClass;}
    public void setUserClass(UserClass userClass){this.userClass = userClass;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public List<StudyTag> getAllStudyTags() {return allStudyTags;}
    public void setAllStudyTags(List<StudyTag> studyTags){this.allStudyTags = studyTags;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}

    public LocalDateTime getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt = updatedAt;}

    public List<Flashcard> getAllFlashCards(){return this.allFlashcards;}
    public void setAllFlashcards(List<Flashcard> flashcards){this.allFlashcards = flashcards;}

}
