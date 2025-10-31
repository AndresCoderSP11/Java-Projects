package com.andres.springboot.di.app.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.springboot.di.app.demo.models.Product;
import com.andres.springboot.di.app.demo.services.ProductServiceImpl;
import com.andres.springboot.di.app.demo.services.ProductService;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class SomeController {
    
    /* Esto aplica si nla parte de =new ProductServiceImpl()  .... sin la necesidad de esto se lleva a cabo ese uso */

    /* En la parte de ProductService... tambien puede ser jalado asi que no hayt problema en ese punto */


    /* Esta parte del productService y tambien la parte
     * Autowired del service .... luego del autowirded cuando el constructor 
     * no se llevaria a cabo o no seria necesario del Autowired
     */
    @Autowired
    private ProductService service;


    public SomeController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list() {
        return service.findAll();
    }   
    
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id){
        return service.findById(id);
    }

}
