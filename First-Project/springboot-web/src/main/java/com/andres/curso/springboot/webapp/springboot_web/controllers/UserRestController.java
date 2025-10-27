package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/* La transformacion de la parte de Controller es con RestController */

@RestController
@RequestMapping("/api")
public class UserRestController {

    @RequestMapping(path="/details",method = RequestMethod.GET)
    public Map<String,Object> details() {
        Map<String,Object> body=new HashMap<>();

        body.put("title", "Welcome to the wordld Spring Boot");
        body.put("nombre", "Andres");
        body.put("lastname", "Salazar Pizarro");

        return body;
    }
}
