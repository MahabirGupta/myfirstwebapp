package com.springboot.myfirstwebapp.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//Create a database to store all these details using MySQL,Oracle
//Create a Static List of ToDos then after that use a real database (H2, MySQL)
//JPA allows us to map the Bean -> DataBase Table by adding the annotation @Entity

@Entity // By default the name of the Table is the same as Class Name (name = "ToDo ABC")
public class ToDo { // Mapping the Todo Bean with a Table in the DataBase

    //    Whenever you have an @Entity you need to define the Primary Key id
    @Id
    @GeneratedValue
    private int id;
    private String username;
    @Size(min = 10,message = "Enter at least 10 characters") // set minimum length of description
    private String description;
    private LocalDate targetDate;
    private boolean completionStatus;

    public ToDo() {
    }

    //    Create constructor
    public ToDo(int id, String username, String description, LocalDate targetDate, boolean completionStatus) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.completionStatus = completionStatus;
    }

    //    Create getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(boolean completionStatus) {
        this.completionStatus = completionStatus;
    }

//    Create toString method
    @Override
    public String toString() {
        return "ToDo{" +
               "id=" + id +
               ", username='" + username + '\'' +
               ", description='" + description + '\'' +
               ", targetDate=" + targetDate +
               ", completionStatus=" + completionStatus +
               '}';
    }
}
