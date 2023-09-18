package com.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Tell Spring that this SayHelloController is a Spring bean using @Controller
@Controller
public class SayHelloController {

//    "say-hello" => "Hello! What are you learning today?"

    //    When someone visits the url "say-hello"
//    url will start with http://localhost:8080/say-hello
//    Configure URL Spring MVC provides you with an annotation
    @RequestMapping("say-hello")

//    returning a string
    @ResponseBody
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    //    create another request mapping to a seperate URL
    @RequestMapping("say-hello-html")

//    returning a string
    @ResponseBody
    public String sayHelloHtml() {

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My first HTML page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first HTML page with body");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }
}
