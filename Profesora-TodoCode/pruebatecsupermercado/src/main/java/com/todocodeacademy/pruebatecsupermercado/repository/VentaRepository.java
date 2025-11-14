package com.todocodeacademy.pruebatecsupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.pruebatecsupermercado.model.Venta;

public interface VentaRepository extends JpaRepository<Venta,Long> {
    
}
