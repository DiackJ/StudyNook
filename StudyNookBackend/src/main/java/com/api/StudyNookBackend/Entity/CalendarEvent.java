package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CalendarEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many events belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    private String title;
    private Date date;
    private String description;

    public CalendarEvent(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public User getUserId(){return this.userId;}
    public void setUserId(User user){this.userId = user;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public Date getDate(){return this.date;}
    public void setDate(Date date){this.date = date;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}
}
