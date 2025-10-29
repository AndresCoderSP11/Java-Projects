package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.models.User;
import com.andres.curso.springboot.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/* Servira para capturar la parte de la ruta Url o la varaible que se tiene definida */

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private String[] listOfValues;

    @Value("${config.code}")
    private Integer code;

    @Value("#{'${config.listOfValues}'.split(',')}") //Transforma en un arreglo la pare de la cadena con de la coma.
    private List<String> valueList;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody() User user) {
        // TODO: process POST request
        // hacer algo con el usuario save
        user.setApellido(user.getApellido().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues",listOfValues);
        json.put("listConver",valueList);
        json.put("valueMap", valuesMap);

        /* Enviroment */

        json.put("message2",environment.getProperty("config.message"));
        json.put("code2",environment.getProperty("config.code"));
        return json;
    }

}
