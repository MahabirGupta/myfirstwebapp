package com.springboot.myfirstwebapp.login;

// We use @Service because it contains Business logic

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authentication(String username,String password){

      boolean isValidUsername = username.equalsIgnoreCase("Mahabir");
      boolean isValidPassword = password.equalsIgnoreCase("anish143");
        return isValidUsername && isValidPassword; //will return true only if both isValidUsername && isValidPassword is true
    }
}
