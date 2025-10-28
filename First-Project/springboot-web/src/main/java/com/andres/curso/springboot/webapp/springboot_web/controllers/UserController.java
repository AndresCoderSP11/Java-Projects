package com.andres.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.andres.curso.springboot.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.andres.curso.springboot.models.User;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class UserController {

    @GetMapping("details-map")
    public String detailsMap(Model model) {
        User user = new User("data","dataLastName","data@gmail.com");
        model.addAttribute("title", "Welcome to the wordld Spring Boot");
        model.addAttribute("nombre", "Andres");
        model.addAttribute("lastname", "Salazar Pizarro");
        model.addAttribute("user", user);
        return "user/details";
    }

    @GetMapping("list")
    public String list(ModelMap model) {

        List<User> users=Arrays.asList(new User("pepa","gonzales","andres"),
        new User("pepa2","gonzales2","andres2"),
        new User("pepa3","gonzales3","andres3"),
        new User("pepa4","gonzales4","andres4")
        );

       /*  List<User> users=new ArrayList<>();
        model.addAttribute("users",users);
        return "user/list"; */

        model.addAttribute("users",users);
        model.addAttribute("title", "Listado de usuarios");
        return "user/list";
    }
    
}
