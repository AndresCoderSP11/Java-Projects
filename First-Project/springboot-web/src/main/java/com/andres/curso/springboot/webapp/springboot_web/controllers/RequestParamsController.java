package com.andres.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.models.dto.ParamDto;
import com.andres.curso.springboot.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam String message) {
        
        ParamDto param=new ParamDto();
        param.setMessage(message);
        return param;

    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text,@RequestParam Integer code) {
        
        ParamMixDto param=new ParamMixDto();
        param.setMessage(text);
        param.setCode(code);
        return param;

    }

    
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request) {
        
        ParamMixDto param=new ParamMixDto();
        param.setCode(Integer.parseInt(request.getParameter("code")));
        param.setMessage(request.getParameter("message"));
        return param;
    }


}
