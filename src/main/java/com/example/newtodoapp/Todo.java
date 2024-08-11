package com.example.newtodoapp;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class Todo {

    public Todo() {
        
    }

    public Todo(int id, String name, String complete, LocalDate date) {
        this.id = id;
        this.name = name;
        this.complete = complete;
        this.date = date;
    }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

  
    @Size(min = 10, message = "Enter at least 10 characters")
    private String complete;

   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

   

  

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getComplete() {
        return complete;
    }
    public void setComplete(String complete) {
        this.complete = complete;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", complete=" + complete + ", date=" + date + "]";
    }
}

