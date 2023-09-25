package com.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//    GET request to get the list of courses
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewToDoPage(){


        return "toDo";
    }

    //    POST request to send the new course
    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewToDoCourse(){
//        List<ToDo> todos=toDoService.findByUserName("Mahabir"); //not ideal solution because need to write duplicate codes
//        model.addAttribute("todos",todos);

//        Do a redirect
        return "redirect:list-todos"; // redirect the page to the list courses page url not jsp
    }
}
