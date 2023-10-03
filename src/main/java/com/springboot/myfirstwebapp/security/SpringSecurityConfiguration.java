package com.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


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

//    All URLs are protected by default
//    A login form is shown for unauthorised requests
//    In order to access the H2 console we need to disable Cross-Site Request Forgery (CSRF)
//    H2 makes use of frames and Spring Security by default does not allow frames. In HTML you can also make use of frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        SecurityFilterChain defines a filter chain matched against every requests
            httpSecurity.authorizeHttpRequests(
              auth -> auth.anyRequest().authenticated()); //lambda expression
        httpSecurity.formLogin(withDefaults());

        //    In order to access the H2 console we need to disable Cross-Site Request Forgery (CSRF)
        httpSecurity.csrf(csrf -> csrf.disable());

        //    H2 makes use of frames and Spring Security by default does not allow frames. In HTML you can also make use of frames
        httpSecurity.headers(headers -> headers.frameOptions(frameOptionsConfig-> frameOptionsConfig.disable()));

        return httpSecurity.build();
    }
}
