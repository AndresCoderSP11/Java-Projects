package com.andres.springboot.di.app.demo.services;

import java.util.List;

import com.andres.springboot.di.app.demo.models.Product;

public interface ProductService {    

    List<Product> findAll();
    Product findById(Long id);

}
