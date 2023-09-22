package com.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller //because it is a @Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    //    url is list-todos
    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap model){
       List<ToDo> todos=toDoService.findByUserName("Mahabir"); //return a list of ToDos
        model.addAttribute("todos",todos);

        return "listToDos"; //return a list of ToDos. Must be the same name as the jsp file
    }
}
