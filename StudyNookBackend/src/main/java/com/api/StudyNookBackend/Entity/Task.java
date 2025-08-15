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
    @JoinColumn(name = "status_category")
    private Category statusCategory;
    //bc one user will have many tasks
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    //bc one task will have many task tags
    @OneToMany(mappedBy = "task")
    private List<TaskTag> allTaskTags;
    private String title;
    private String optionalDescription;
    private Date optionalDueDate;
    private Date createdAt;
    private String status;

//no args constructor to create objects but need to define list type.
    public Task(){
        this.allTaskTags = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Board getBoardId(){return this.boardId;}
    public void setBoardId(Board boardId){this.boardId = boardId;}

    public Category getStatusCategory(){return this.statusCategory;}
    public void setStatusCategory(Category category){this.statusCategory = category;}

    public User getUserId(){return this.userId;}
    public void setUserId(User user){this.userId = user;}

    public Date getCreatedAt(){return this.createdAt;}
    public void setCreatedAt(Date created){this.createdAt = created;}

    public Date getOptionalDueDate(){return this.optionalDueDate;}
    public void setOptionalDueDate(Date date){this.optionalDueDate = date;}

    public String getOptionalDescription(){return this.optionalDescription;}
    public void setOptionalDescription(String description){this.optionalDescription = description;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public List<TaskTag> getAllTaskTags(){return this.allTaskTags;}
    public void setAllTaskTags(List<TaskTag> taskTags){this.allTaskTags = taskTags;}

    public String getStatus(){return this.status;}
    public void setStatus(String status){this.status = status;}
}
