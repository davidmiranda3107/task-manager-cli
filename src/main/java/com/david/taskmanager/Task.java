package com.david.taskmanager;


import java.time.LocalDateTime;

public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDateTime createdAt;

    public Task() { }

    public Task(int id, String title, String description, boolean complete) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = complete;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }

}
