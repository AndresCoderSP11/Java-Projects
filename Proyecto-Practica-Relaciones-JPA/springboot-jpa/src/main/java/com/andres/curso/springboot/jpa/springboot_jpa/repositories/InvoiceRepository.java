package com.andres.curso.springboot.jpa.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.curso.springboot.jpa.springboot_jpa.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice,Long>{
  
} 
