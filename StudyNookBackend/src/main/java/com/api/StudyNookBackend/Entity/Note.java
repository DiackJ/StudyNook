package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many notes may belong to one notebook
    @ManyToOne
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;
    //bc many notes belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //bc one note may have many note tags
    @OneToMany(mappedBy = "note")
    private List<NoteTag> allNoteTags;
    private String title;
    private Date createdAt;
    private Date updatedAt;
    private String content;

    //no args constructor but need to define type of list
    public Note(){
        this.allNoteTags = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Notebook getNotebook(){return this.notebook;}
    public void setNotebook(Notebook notebook){this.notebook = notebook;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public List<NoteTag> getAllNoteTags(){return this.allNoteTags;}
    public void setAllNoteTags(List<NoteTag> noteTags){this.allNoteTags = noteTags;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date date){this.createdAt = date;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date date){this.updatedAt = date;}

    public String getContent(){return this.content;}
    public void setContent(String content){this.content = content;}
}
