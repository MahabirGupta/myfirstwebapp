package com.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    //    Create a ToDo list
    private static List<ToDo> todos = new ArrayList<>();

//    Current count for list of courses
//    private static int todosCount = 3;
    private static int todosCount = 0;


    //    If you want to initialse a static variable you need to create a static block
    static {
// Everytime a new course will be added the todosCount will increase by 1
        todos.add(new ToDo(++todosCount, "Mahabir", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(++todosCount, "Mahabir", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(++todosCount, "Mahabir", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));

    }

    public List<ToDo> findByUserName(String userName){

        return todos; //returns all the list of ToDo
    }

//    Add todo to the Todo list
    public void addToDo(String username, String description, LocalDate targetDate, boolean completionStatus ){
        ToDo toDo = new ToDo(++todosCount,username,description,targetDate,completionStatus);
        todos.add(toDo); //todos is an array list

    }
}
