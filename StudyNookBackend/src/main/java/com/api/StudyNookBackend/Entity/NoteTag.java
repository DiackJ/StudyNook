package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

@Entity
public class NoteTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many note tags belong to one note
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note noteId;
    //bc many note tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTagId;
    private String name;

    public NoteTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Note getNoteId(){return this.noteId;}
    public void setNoteId(Note noteId){this.noteId = noteId;}

    public UserTag getUserTagId(){return this.userTagId;}
    public void setUserTagId(UserTag userTagId){this.userTagId = userTagId;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
