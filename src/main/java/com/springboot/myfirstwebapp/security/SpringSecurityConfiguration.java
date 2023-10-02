package com.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration // configuration of a number of Spring Beans
public class SpringSecurityConfiguration {

//    create a number of spring beans and return them back
//    Use LDAP or a database to create username and password

//    For this project use InMemory

//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users);

//    Creating the entire bean for own user configuration
    @Bean
    public InMemoryUserDetailsManager configureUserDetails(){
//        UserDetails is an interface so cannot create an instance of it. Use User class instead

//        String username = "Mahabir";

        UserDetails userDetails1 = createNewUser("Mahabir","anish143");
        UserDetails userDetails2 = createNewUser("Anish","anishkaa143");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input); //lambda function

        UserDetails userDetails =User.builder().passwordEncoder(passwordEncoder).username(username).password(password).roles("USER","ADMIN").build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){ // use PasswordEncoder passwordEncoder because withDefaultPasswordEncoder() is deprecated
        return new BCryptPasswordEncoder();
    }


}
