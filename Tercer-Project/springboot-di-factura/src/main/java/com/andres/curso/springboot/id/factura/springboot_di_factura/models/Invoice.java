package com.andres.curso.springboot.id.factura.springboot_di_factura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@ApplicationScope
@RequestScope
/* @JsonIgnoreProperties({"targetSource","advisors"}) */
public class Invoice {
    
    /* Extraccion de la parte de Clase sin necesidad de declarar */
    @Autowired
    private Client client;

    @Value("${invoice.description}")
    private String description;
    
    /* Denominacion de la parte de ListItem */
    @Autowired  
    @Qualifier("default")
    private List<Item> items;

    public Invoice(){
         System.out.println("Creando el componente de la factura");
    }

    /* Obtiene todass las infromacion de antes de tu PostCOnstuct */
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Despues el componente o bean invoiced!");
    }


  
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal(){
        int total=0;
        /* Del objeto de la parte de item, desde la list de items... que se declar
         * raron en la parte de items
         */
        for (Item item : items) {
            total=total + item.getImporte(); /* Esta es la parte 
             */
        }
        
        
        return total;
    }


}
