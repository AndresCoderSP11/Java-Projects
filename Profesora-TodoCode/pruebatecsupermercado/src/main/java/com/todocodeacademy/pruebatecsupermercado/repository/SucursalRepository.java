package com.todocodeacademy.pruebatecsupermercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todocodeacademy.pruebatecsupermercado.model.Sucursal;

/* Tipo de dato de Id , osea a la derecha <,%AQUI DATO DEL ID%> */
public interface SucursalRepository extends JpaRepository<Sucursal,Long>{
    
}
