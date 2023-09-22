package com.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") //want to put the "name" attributes
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());

//    http://localhost:8080/login?name=Mahabir
//    Model
//    @RequestMapping("login")
//    public String goToLogInPage(@RequestParam String name, ModelMap model) { //because we are sending the name to the login url
//
//        model.put("name",name);
////        logger.debug("Request param is {}",name); // instead of appending use curly brackets {} if want to print at debug level
////        logger.info("I want this printed at info level");
////        logger.warn("I want this printed at warn level");
//
////        System.out.println("Request param is " + name); //should not use System.out.println for Production Code
//        return "login"; //returning back the name of the JSP
//    }

//    private AuthenticationService authenticationService = new AuthenticationService(); //if not using spring
private AuthenticationService authenticationService;
//    Use constructor injection

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    //    login is handing both GET and POST request
    @RequestMapping(value="login",method= RequestMethod.GET)
    public String goToLogInPage(){

        return "login";
    }

    @RequestMapping(value="login",method= RequestMethod.POST)
//    login?name=Mahabir RequestParam
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){

        if (authenticationService.authentication(name,password)){

        model.put("name",name);
//        model.put("password",password);

//        If a specific username and password is entered then it will go to welcome page - Authentication
//        Valid username:Mahabir
//        Valid password:anish143
        return "welcome";
        }
        model.put("errorMessage","Invalid Credentials! Please try again.");
        return "login";
    }
}
