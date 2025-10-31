package com.andres.springboot.di.app.demo.repositories;

import java.util.List;
import com.andres.springboot.di.app.demo.models.Product;

public interface ProductoRepository {
    List<Product> findAll();

    Product findById(Long id);
}
