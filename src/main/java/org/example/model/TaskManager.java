package org.example.model;
import java.sql.Date;


public class TaskManager {

    //Declaring Variables
    private int id;
    private String name;
    private String description;
    private Date dueDate;

    //No-arg Constructor
    public TaskManager(){

    }

    //Constructor
    public TaskManager(int id, String name, String description, Date dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
