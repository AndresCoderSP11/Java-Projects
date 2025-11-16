package com.todocodeacademy.pruebatecsupermercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.pruebatecsupermercado.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Optional<Producto> findByNombre(String nombre);


}