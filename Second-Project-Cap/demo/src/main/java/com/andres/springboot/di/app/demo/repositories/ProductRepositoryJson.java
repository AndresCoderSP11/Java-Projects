package com.andres.springboot.di.app.demo.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.andres.springboot.di.app.demo.models.Product;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;
    public ProductRepositoryJson(){
        ClassPathResource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            list=Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
        } catch (StreamReadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatabindException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }


    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public Product findById(Long id) {
        // TODO Auto-generated method stub
            return list.stream().filter(p ->{
                return p.getId().equals(id);
            }).findFirst().orElseThrow();




    }
    
}
