package com.todocodeacademy.pruebatecsupermercado.mapper;

import java.util.stream.Collectors;

import com.todocodeacademy.pruebatecsupermercado.dto.DetalleVentaDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.ProductoDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.SucursalDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.VentaDTO;
import com.todocodeacademy.pruebatecsupermercado.model.Producto;
import com.todocodeacademy.pruebatecsupermercado.model.Sucursal;
import com.todocodeacademy.pruebatecsupermercado.model.Venta;


/* Inicialmente recordar que los Builder se tienen que pasar con uso de lombok en cada parte de DTO */

public class Mapper {
    

    //Mapeo de Producto a ProductoDTO

    public static ProductoDTO toDTO(Producto p){
        if(p==null) return null;
        return ProductoDTO.builder()
            .id(p.getId())
            .nombre(p.getNombre())
            .categoria(p.getCategoria())
            .precio(p.getPrecio())
            .build();
    }

    //Mapeo de Venta a VentaDTO

    //Mapeo de Sucursal a SucursalDTO

     public static SucursalDTO toDTO(Sucursal s) {
        if (s == null) return null;
        return SucursalDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .direccion(s.getDireccion())
                .build();
    }

      //Mapeo de Venta a VentaDTO
    public static VentaDTO toDTO(Venta venta) {
        if (venta == null) return null;
        /* Esta parteva traer todo el array list del Detalle 
         * determinado , es por elo que crea o trae un det si lo vemos asi
         */

         /* ##### DETALLES SON LA PARTE DE  */
        var detalle = venta.getDetalle().stream().map(det ->
                DetalleVentaDTO.builder()
                        .id(det.getProd().getId())
                        .nombreProd(det.getProd().getNombre())
                        .cantProd(det.getCantProd())
                        .precio(det.getPrecio())
                        .subtotal(det.getPrecio() * det.getCantProd())
                        .build()
        ).collect(Collectors.toList());

        var total = detalle.stream()
                .map(DetalleVentaDTO::getSubtotal)
                .reduce(0.0, Double::sum);

        return VentaDTO.builder()
                .id(venta.getId())
                .fecha(venta.getFecha())
                .idSucursal(venta.getSucursal().getId())
                .estado(venta.getEstado())
                .detalle(detalle)
                .total(total)
                .build();
    }






}
