package com.springboot.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller //because it is a @Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

//    private ToDoService toDoService;

//    use JPA to communicate with the Table in H2 DataBase
    private ToDoRepository toDoRepository;

    public ToDoControllerJpa(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
//   Not required
//    public ToDoControllerJpa(ToDoService toDoService, ToDoRepository toDoRepository) {// to autowire ToDoRepository
//        super();
//        this.toDoService = toDoService;
//        this.toDoRepository = toDoRepository;
//    }

    //    url is list-todos
    @RequestMapping("list-todos")
    public String listAllToDos(ModelMap model){
        String username = (String) model.get("name");// model.get("name") will get the name of the user

        toDoRepository.getById(1); //to get the course from H2 DataBase
        toDoRepository.deleteById(2); // to delete the course from H2 DataBase

       List<ToDo> todos=toDoRepository.findByUsername(username); //return a list of ToDos
        model.addAttribute("todos",todos);

        return "listToDos"; //return a list of ToDos. Must be the same name as the jsp file
    }


//    GET request to get the list of courses
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap model){
        String username = (String) model.get("name");// model.get("name") will get the name of the user
        ToDo toDo = new ToDo(0,username,"",LocalDate.now().plusYears(1),false);//creating a new todo and setting default values
        model.put("toDo",toDo); // "toDo",toDo must be the same name as the object of ToDo
        return "toDo";
    }

    //    POST request to send the new course
//    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
//        public String addNewToDoCourse(@RequestParam String description,ModelMap model){
//            String username = (String) model.get("name");// model.get("name") will get the name of the user
//            toDoService.addToDo(username,description, LocalDate.now().plusYears(1),false);
////        Do a redirect
//            return "redirect:list-todos"; // redirect the page to the list courses page url not jsp
//    }

//    Command Bean (Form Backing Object)
    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewToDoCourse(ModelMap model, @Valid ToDo toDo, BindingResult result){// Telling Spring MVC to bind directly to the todo bean

//        @Valid ToDo toDo will ensure that to-do bean is validated before the binding happens

        if(result.hasErrors()){
            return "toDo";
        }

        String username = (String) model.get("name");// model.get("name") will get the name of the user
        toDo.setUsername(username);
        toDoRepository.save(toDo); // the save() method on the ToDoRepository will accept toDo as an input
//        toDoService.addToDo(username,toDo.getDescription(), toDo.getTargetDate(), toDo.isCompletionStatus()); //not required because using toDoRepository
//        Do a redirect
        return "redirect:list-todos"; // redirect the page to the list courses page url not jsp
    }

    //    delete a todo
    @RequestMapping("delete-todo") //the url link
    public String deleteToDo(@RequestParam int id){

//        Delete todo with id
        toDoRepository.deleteById(id);

//        Implement the logic in ToDoService to delete todo by Id
//        toDoService.deleteById(id);

        return "redirect:list-todos"; // redirect the page to the list courses page url not jsp

    }

    @RequestMapping(value = "update-todo",method = RequestMethod.GET) //the url link
    public String showUpdateToDoPage(@RequestParam int id, ModelMap model){

        ToDo toDo = toDoRepository.findById(id).get();// findById returns an optional. From the optional to get a todo need to use .get()

//        ToDo toDo = toDoService.findById(id);
        model.addAttribute("toDo",toDo);
        return "toDo"; // redirect the page to the list courses page url not jsp

    }

    //    Command Bean (Form Backing Object)
    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String updateToDoCourse(ModelMap model, @Valid ToDo toDo, BindingResult result){// Telling Spring MVC to bind directly to the todo bean

//        @Valid ToDo toDo will ensure that toDo bean is validated before the binding happens

        if(result.hasErrors()){
            return "toDo";
        }

        String username = (String) model.get("name");// model.get("name") will get the name of the user
        toDo.setUsername(username);
        toDoRepository.save(toDo);

//        toDoService.updateToDo(toDo);
//        Do a redirect
        return "redirect:list-todos"; // redirect the page to the list courses page url not jsp
    }

    private String getLoggedInUserName(ModelMap model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); //getting UserName
    }
}

