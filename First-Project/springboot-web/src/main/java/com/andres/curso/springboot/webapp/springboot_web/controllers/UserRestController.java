package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.models.User;
import com.andres.curso.springboot.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import java.util.List;
/* La transformacion de la parte de Controller es con RestController */
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path="/details",method = RequestMethod.GET)
    public UserDto details() {
         User user = new User("Andres", "Salazar Pizarro","andres.gamail.com"); 
        UserDto userDto=new UserDto();
               
        userDto.setUser(user);
        userDto.setTitle("Welcome to the wordld Spring Boot");
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list(){
        User user=new User("Andres","Salazar","andres.user.gamail.com");
        User user2=new User("John","Doe","delete.gmail.com");
        User user3=new User("Jane","Kelvin","xdd@gmail.com");
        
        List<User> users=Arrays.asList(user,user2,user3);

       /*  List<User> users=new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3); */
        
        return users;
    }









}
