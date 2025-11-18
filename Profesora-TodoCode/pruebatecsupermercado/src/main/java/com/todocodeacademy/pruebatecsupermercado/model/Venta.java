package com.todocodeacademy.pruebatecsupermercado.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private String estado;

    /* Verificacion de que muchas ventas pueden pertenecer a una Sola sucurssal */
    private Double total;

    @ManyToOne
    private Sucursal sucursal;

    /* Con esto se puede tener en cuenta la parte de que JPA cree todo ello */
    /* FETCHTYPE ,  Es traer la data de cada Objeto de Producto
     * cono en Nest si trae o no 
     */

    @OneToMany(mappedBy = "venta",cascade = CascadeType.ALL,
    orphanRemoval = true,fetch=FetchType.EAGER) /* Tiene que se lap arte del mapeo de venta */
    private List<DetalleVenta> detalle = new ArrayList<>();
    
}
