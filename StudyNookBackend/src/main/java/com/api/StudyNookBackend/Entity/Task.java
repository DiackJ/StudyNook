package com.api.StudyNookBackend.Entity;

import jakarta.persistence.*;

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
    private Board boardId;
    //bc one category will have many tasks
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;
    //bc one user will have many tasks
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    //bc one task will have many task tags
    @OneToMany(mappedBy = "task")
    private List<TaskTag> allTaskTags;
    private String title;
    private String description;
    private Date dueDate;
    private Date createdAt;
    private Date updatedAt;

//no args constructor to create objects but need to define list type.
    public Task(){
        this.allTaskTags = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Board getBoardId(){return this.boardId;}
    public void setBoardId(Board boardId){this.boardId = boardId;}

    public Category getCategoryId(){return this.categoryId;}
    public void setCategoryId(Category categoryId){this.categoryId = categoryId;}

    public User getUserId(){return this.userId;}
    public void setUserId(User user){this.userId = user;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date created){this.createdAt = created;}

    public Date getDueDate(){return this.dueDate;}
    public void setDueDate(Date date){this.dueDate = date;}

    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public List<TaskTag> getAllTaskTags(){return this.allTaskTags;}
    public void setAllTaskTags(List<TaskTag> taskTags){this.allTaskTags = taskTags;}

    public Date getUpdatedAt(){return this.updatedAt;}
    public void setUpdatedAt(Date date){this.updatedAt = date;}
}
