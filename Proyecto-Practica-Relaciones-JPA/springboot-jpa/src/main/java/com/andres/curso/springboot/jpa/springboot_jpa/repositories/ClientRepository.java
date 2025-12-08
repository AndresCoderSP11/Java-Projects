package com.andres.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.andres.curso.springboot.jpa.springboot_jpa.models.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
}
