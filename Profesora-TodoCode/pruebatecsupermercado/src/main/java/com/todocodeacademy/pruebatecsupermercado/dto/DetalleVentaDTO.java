package com.todocodeacademy.pruebatecsupermercado.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetalleVentaDTO {

    /* En este caso falto la parte de Id Producto ... para que defina la parte de ello
     * si se agregga ello se hace usop tambien 
     * de la aprte de Mapper como tambien la parte de Service
     */

    private Long id;
    private String nombreProd;
    private Integer cantProd;
    private Double precio;
    private Double subtotal;
}
