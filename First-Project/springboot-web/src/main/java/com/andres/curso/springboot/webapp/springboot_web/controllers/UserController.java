package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.andres.curso.springboot.models.dto.UserDto;
import org.springframework.ui.Model;
import com.andres.curso.springboot.models.User;



@Controller
public class UserController {

   

    @GetMapping("details-map")
    public String detailsMap(Model model) {
        model.addAttribute("title", "Welcome to the wordld Spring Boot");
        model.addAttribute("nombre", "Andres");
        model.addAttribute("lastname", "Salazar Pizarro");
        return "user/details";
    }
}
