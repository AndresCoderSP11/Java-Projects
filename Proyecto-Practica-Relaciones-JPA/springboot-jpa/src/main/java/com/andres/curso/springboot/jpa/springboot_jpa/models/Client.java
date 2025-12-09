package com.andres.curso.springboot.jpa.springboot_jpa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    /* Un cliente tiene muchos addresses */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    public Client() {
        addresses=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Client {id=" + id + ", name=" + name + ", lastname=" + lastname + ", addresses=" + addresses + "}";
    }

    
}
