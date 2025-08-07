package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

@Entity
public class TaskTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc many task tags belong to one task
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    //bc many task tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTag;
    private String name;

    public TaskTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Task getTask(){return this.task;}
    public void setTask(Task task){this.task = task;}

    public UserTag getUserTag(){return this.userTag;}
    public void setUserTag(UserTag userTag){this.userTag = userTag;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
