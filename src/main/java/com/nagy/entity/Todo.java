package com.nagy.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "task should not be empty")
    private String task ;
    @NotEmpty(message = "Title should not be empty")
    @Size(max = 50, message = "task should not be greater than 50 character")
    private String title ;

    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Due date should be in the present or the future")
    @JsonbDateFormat(value = "yyy-MM-dd")
    private LocalDate  dueDate ;
    private Boolean isCompleted ;
    private LocalDate dataCreated ;
    private LocalDate dateCompleted ;

    @PrePersist
    private void init(){
        setDataCreated(LocalDate.now());
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    public LocalDate getDataCreated() {
        return dataCreated;
    }

    public void setDataCreated(LocalDate dataCreated) {
        this.dataCreated = dataCreated;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
