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
    private Task taskId;
    //bc many task tags belong to one global user tag holder
    @ManyToOne
    @JoinColumn(name = "user_tag_id")
    private UserTag userTagId;
    private String name;

    public TaskTag(){}

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Task getTaskId(){return this.taskId;}
    public void setTaskId(Task taskId){this.taskId = taskId;}

    public UserTag getUserTagId(){return this.userTagId;}
    public void setUserTagId(UserTag userTagId){this.userTagId = userTagId;}

    public String getName(){return this.name;}
    public void setName(String name){this.name = name;}
}
