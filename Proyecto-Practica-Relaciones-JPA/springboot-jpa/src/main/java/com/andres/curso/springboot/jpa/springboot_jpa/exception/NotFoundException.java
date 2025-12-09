package com.andres.curso.springboot.jpa.springboot_jpa.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String msje){
        super(msje);
    }
}
