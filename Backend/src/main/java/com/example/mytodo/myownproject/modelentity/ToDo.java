package com.example.mytodo.myownproject.modelentity;


import jakarta.persistence.*;

@Entity  // entity endhuku ante ee class variables aa Data Base lo tanle colums avuthayi kabatti
@Table(name="todos")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database itself create teh ID in database
    private long id;
    private String title;
    private Boolean completed;

    public ToDo() {
    }

    public ToDo(String title, Boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Boolean isCompleted() {
        return completed;
    }
}
