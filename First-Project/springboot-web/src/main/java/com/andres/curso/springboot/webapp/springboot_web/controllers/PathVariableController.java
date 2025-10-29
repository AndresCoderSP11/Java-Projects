package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.models.dto.ParamDto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


/* Servira para capturar la parte de la ruta Url o la varaible que se tiene definida */

@RestController
@RequestMapping("/api/var")
public class PathVariableController {
 
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param=new ParamDto();
        param.setMessage(message);
        return param;
    }
    

    @GetMapping("/mix/{product}/{id}")
    public Map<String,Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String,Object> json=new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }
    

}
