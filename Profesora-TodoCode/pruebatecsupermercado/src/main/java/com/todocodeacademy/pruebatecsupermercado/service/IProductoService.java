package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.List;

import com.todocodeacademy.pruebatecsupermercado.dto.ProductoDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.SucursalDTO;

public interface IProductoService {
    List<ProductoDTO> traerProductos();
    ProductoDTO crearProducto(ProductoDTO sucursalDto);
    ProductoDTO actualizarProducto(Long id, ProductoDTO sucursalDto);
    void eliminarProducto(Long id);

}
