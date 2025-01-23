package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class Todo {
    private int id;

    private String name;

    private Date duedate;
    private String status;

    public Todo(int id, String name, Date duedate, String status) {
        this.id = id;
        this.name = name;
        this.duedate = duedate;
        this.status = status;
    }
    public Todo() {
    }


    @Id
    @GeneratedValue
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

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duedate=" + duedate +
                ", status='" + status + '\'' +
                '}';
    }



}
