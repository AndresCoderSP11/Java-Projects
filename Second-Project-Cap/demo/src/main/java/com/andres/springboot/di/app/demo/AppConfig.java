package com.andres.springboot.di.app.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.andres.springboot.di.app.demo.repositories.ProductRepository;
import com.andres.springboot.di.app.demo.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
    
    @Bean
    @Primary
    ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson();
    
    }




}
