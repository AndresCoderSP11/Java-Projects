package com.andres.springboot.di.app.demo.repositories;

import com.andres.springboot.di.app.demo.models.Product;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

/* SE esta teniendno como un tipado por parte de productRepositoryu , debidoa que esto es una Interfdase */
/* @Primary */
/* @RequestScope */   
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl(){
        this.data=Arrays.asList(
            new Product(1L,"Memoria corsarir 32 ",300L),
            new Product(2L," corsarir 32 ",300L),
            new Product(3L," Memoria Ram 32GB ",400L),
            new Product(2L,"Placa Madre 5000Mhz 32 ",500L)
        );
    }

    @Override
    public List<Product> findAll(){
        return data;
    }

    @Override
    /* Obtiene el orElse para obtener el dato nulo si no tiene la parte de findById */
    public Product findById(Long id){
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }


}
