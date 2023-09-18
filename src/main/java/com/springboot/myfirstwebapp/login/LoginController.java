package com.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class LoginController {
    @RequestMapping("login")
    public String goToLogInPage() {
        return "login"; //returning back the name of the JSP
    }
}
