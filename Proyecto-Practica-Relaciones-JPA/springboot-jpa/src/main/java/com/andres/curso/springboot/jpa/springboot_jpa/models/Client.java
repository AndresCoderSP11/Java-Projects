package com.andres.curso.springboot.jpa.springboot_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String lastname;

    public Client() {
    }

    
}
