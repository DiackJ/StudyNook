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
    private Board board;
    //bc one category will have many tasks
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category statusCategory;
    //bc one user will have many tasks
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdByUser;
    //bc one task will have many task tags
    @OneToMany(mappedBy = "task")
    private List<TaskTag> allTaskTags;
    private String title;
    private String optionalDescription;
    private Date optionalDueDate;
    private Date createdAt;

//no args constructor to create objects but need to define list type.
    public Task(){
        this.allTaskTags = new ArrayList<>();
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public Board getBoard(){return this.board;}
    public void setBoard(Board board){this.board = board;}

    public Category getStatusCategory(){return this.statusCategory;}
    public void setStatusCategory(Category category){this.statusCategory = category;}

    public User getCreatedByUser(){return this.createdByUser;}
    public void setCreatedByUser(User user){this.createdByUser = user;}

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
}
