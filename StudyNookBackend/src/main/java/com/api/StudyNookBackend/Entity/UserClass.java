package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many classes belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //bc one class will have many boards, study sets and notebooks
    @OneToMany(mappedBy = "userClass")
    private List<Board> allBoards;
    @OneToMany(mappedBy = "userClass")
    private List<StudySet> allStudySets;
    @OneToMany(mappedBy = "userClass")
    private List<Notebook> allNotebooks;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public UserClass(){
        this.allBoards = new ArrayList<>();
        this.allNotebooks = new ArrayList<>();
        this.allStudySets = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public List<Board> getAllBoards(){return this.allBoards;}
    public void setAllBoards(List<Board> boards){this.allBoards = boards;}

    public List<StudySet> getAllStudySets(){return this.allStudySets;}
    public void setAllStudySets(List<StudySet> studySets){this.allStudySets = studySets;}

    public List<Notebook> getAllNotebooks(){return this.allNotebooks;}
    public void setAllNotebooks(List<Notebook> notebooks){this.allNotebooks = notebooks;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public Timestamp getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Timestamp date){this.createdAt = date;}

    public Timestamp getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Timestamp date){this.updatedAt = date;}
}
