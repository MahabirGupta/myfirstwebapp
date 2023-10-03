package com.springboot.myfirstwebapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {//ToDo is the Entity Bean

    public List<ToDo> findByUsername(String username); //find the list of ToDos by username
                                                       //username is an attribute inside the ToDo Bean Spring Data JPA
    // will automatically provide a method to search by username
}
