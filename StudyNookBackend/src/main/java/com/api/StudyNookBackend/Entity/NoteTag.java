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
    private Note note;
    //bc many note tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTag;
    private String name;

    public NoteTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Note getNoteId(){return this.note;}
    public void setNoteId(Note noteId){this.note = noteId;}

    public UserTag getUserTag(){return this.userTag;}
    public void setUserTag(UserTag userTag){this.userTag = userTag;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
