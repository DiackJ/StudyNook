package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Notebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc one class may have many notebooks
    @ManyToOne
    @JoinColumn(name = "user_class")
    private UserClass userClass;
    //bc one notebook may have many notes
    @OneToMany(mappedBy = "notebook")
    private List<Note> allNotes;
    //bc many notebooks belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String title;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Notebook(){
        this.allNotes = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public UserClass getUserClass(){return this.userClass;}
    public void setUserClass(UserClass userClass){this.userClass = userClass;}

    public List<Note> getAllNotes(){return this.allNotes;}
    public void setAllNotes(List<Note> notes){this.allNotes = notes;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt = createdAt;}

    public LocalDateTime getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime date){this.updatedAt = date;}
}
