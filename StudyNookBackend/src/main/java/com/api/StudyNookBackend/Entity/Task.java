package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //bc one board will have many tasks
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
    //bc one category will have many tasks
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    //bc one user will have many tasks
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    //bc one task will have many task tags
    @OneToMany(mappedBy = "task")
    private List<TaskTag> allTaskTags;
    private String title;
    private String description;
    private Date dueDate;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//no args constructor to create objects but need to define list type.
    public Task(){
        this.allTaskTags = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Board getBoardId(){return this.board;}
    public void setBoardId(Board boardId){this.board = boardId;}

    public Category getCategory(){return this.category;}
    public void setCategory(Category category){this.category = category;}

    public User getUser(){return this.user;}
    public void setUser(User user){this.user = user;}

    public LocalDateTime getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(LocalDateTime created){this.createdAt = created;}

    public Date getDueDate(){return this.dueDate;}
    public void setDueDate(Date date){this.dueDate = date;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public List<TaskTag> getAllTaskTags(){return this.allTaskTags;}
    public void setAllTaskTags(List<TaskTag> taskTags){this.allTaskTags = taskTags;}

    public LocalDateTime getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(LocalDateTime date){this.updatedAt = date;}
}
