package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

//    http://localhost:8080/login?name=Mahabir
//    Model
    @RequestMapping("login")
    public String goToLogInPage(@RequestParam String name, ModelMap model) { //because we are sending the name to the login url
        model.put("name",name);
        System.out.println("Request param is " + name); //should not use System.out.println for Production Code
        return "login"; //returning back the name of the JSP
    }
}
