package com.andres.springboot.di.app.demo.repositories;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.andres.springboot.di.app.demo.models.Product;

@Primary
@Repository
public class ProductRepositoryFoo implements ProductRepository{

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return Collections.singletonList(new Product(1L,"Monitor 600 Pulgadas",300l));
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
        return new Product(id,"Monitor 600 Pulgadas",300l);
    }
    
}
