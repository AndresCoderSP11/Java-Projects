package com.andres.curso.springboot.jpa.springboot_jpa.models;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="invoices")
public class Invoice {
    
    /* En este caso un Cliente tiene muchas facturas Entonces se va mantener una Relacion */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Long total;

    @ManyToOne
    private Client cliente;

    @Override
    public String toString() {
        return "{id=" + id + ", description=" + description + ", total=" + total + ", cliente=" + cliente + "}";
    }


}
