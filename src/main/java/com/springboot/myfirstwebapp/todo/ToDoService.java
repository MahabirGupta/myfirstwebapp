package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class ToDoService {

    //    Create a ToDo list
    private static List<ToDo> todos;

    //    If you want to initialse a static variable you need to create a static block
    static {

        todos.add(new ToDo(1, "Mahabir", "Learn AWS", LocalDate.now().plusYears(1), false));
        todos.add(new ToDo(2, "Mahabir", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todos.add(new ToDo(3, "Mahabir", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));

    }

    public List<ToDo> findByUserName(String userName){

        return todos; //returns all the list of ToDo
    }
}
