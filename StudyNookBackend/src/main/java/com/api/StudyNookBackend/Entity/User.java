package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    //bc one user will have one global tag container
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_tag_id", referencedColumnName = "id")
    private UserTag userTag;
    //bc one user will have many classes, calendar events, flashcards, boards, study sets, notebooks, notes, and tasks
    @OneToMany(mappedBy = "user")
    private List<UserClass> allUserClasses;
    @OneToMany(mappedBy = "user")
    private List<CalendarEvent> allCalendarEvents;
    @OneToMany(mappedBy = "user")
    private List<Flashcard> allFlashcards;
    @OneToMany(mappedBy = "user")
    private List<Board> allBoards;
    @OneToMany(mappedBy = "user")
    private List<StudySet> allStudySets;
    @OneToMany(mappedBy = "user")
    private List<Notebook> allNotebooks;
    @OneToMany(mappedBy = "user")
    private List<Note> allNotes;
    @OneToMany(mappedBy = "user")
    private List<Task> allTasks;


    public User(){
        this.allUserClasses = new ArrayList<>();
        this.allCalendarEvents = new ArrayList<>();
        this.allFlashcards = new ArrayList<>();
        this.allBoards = new ArrayList<>();
        this.allStudySets = new ArrayList<>();
        this.allNotebooks = new ArrayList<>();
        this.allNotes = new ArrayList<>();
        this.allTasks =new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return this.email;}
    public void setEmail(String email){this.email = email;}

    public String getPassword(){return this.password;}
    public void setPassword(String password){this.password = password;}

    public Timestamp getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Timestamp createdAt){this.createdAt = createdAt;}

    public Timestamp getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Timestamp updatedAt){this.updatedAt = updatedAt;}

    public UserTag getUserTag(){return this.userTag;}
    public void setUserTag(UserTag tags){this.userTag = tags;}

    public List<UserClass> getAllUserClasses(){return this.allUserClasses;}
    public void setAllUserClasses(List<UserClass> classes){this.allUserClasses = classes;}

    public List<CalendarEvent> getAllCalendarEvents(){return this.allCalendarEvents;}
    public void setAllCalendarEvents(List<CalendarEvent> events){this.allCalendarEvents = events;}

    public List<Flashcard> getAllFlashcards(){return this.allFlashcards;}
    public void setAllFlashcards(List<Flashcard> flashcards){this.allFlashcards = flashcards;}

    public List<Board> getAllBoards(){return this.allBoards;}
    public void setAllBoards(List<Board> boards){this.allBoards = boards;}

    public List<StudySet> getAllStudySets(){return this.allStudySets;}
    public void setAllStudySets(List<StudySet> studySets){this.allStudySets = studySets;}

    public List<Notebook> getAllNotebooks(){return this.allNotebooks;}
    public void setAllNotebooks(List<Notebook> notebooks){this.allNotebooks = notebooks;}

    public List<Note> getAllNotes(){return this.allNotes;}
    public void setAllNotes(List<Note> notes){this.allNotes = notes;}

    public List<Task> getAllTasks(){return this.allTasks;}
    public void setALlTasks(List<Task> tasks){this.allTasks = tasks;}
}
