package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.models.User;
import com.andres.curso.springboot.models.dto.UserDto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/* La transformacion de la parte de Controller es con RestController */

@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path="/details",method = RequestMethod.GET)
    public UserDto details() {
         User user = new User("Andres", "Salazar Pizarro"); 
        UserDto userDto=new UserDto();
               
        userDto.setUser(user);
        userDto.setTitle("Welcome to the wordld Spring Boot");
        return userDto;
    }
}
