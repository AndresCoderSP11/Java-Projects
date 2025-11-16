package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.pruebatecsupermercado.dto.ProductoDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.SucursalDTO;
import com.todocodeacademy.pruebatecsupermercado.exception.NotFoundException;
import com.todocodeacademy.pruebatecsupermercado.mapper.Mapper;
import com.todocodeacademy.pruebatecsupermercado.model.Producto;
import com.todocodeacademy.pruebatecsupermercado.model.Sucursal;
import com.todocodeacademy.pruebatecsupermercado.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService{


    /* Recordar que la parte de  */
    @Autowired
    private ProductoRepository repo;

    @Override
    public List<ProductoDTO> traerProductos() {
        // TODO Auto-generated method stub
        /* Realiza la parte de TODTO hacia lo solicitado en la parte de PRODUCTO */        
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDto) {
        var prod= Producto.builder()
                    .nombre(productoDto.getNombre())
                    .categoria(productoDto.getCategoria())
                    .precio(productoDto.getPrecio())
                    .cantidad(productoDto.getCantidad())
                    .build();
        return Mapper.toDTO(repo.save(prod));
    }

    @Override
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoDto) {
        Producto prod =repo.findById(id)
            .orElseThrow(()->new NotFoundException("Producto No encontrado"));

        prod.setNombre(productoDto.getNombre());
        prod.setCategoria(productoDto.getCategoria());
        prod.setCantidad(productoDto.getCantidad());
        prod.setPrecio(productoDto.getPrecio());

        return Mapper.toDTO(repo.save(prod));

    }

    @Override
    public void eliminarProducto(Long id) {
       
        if(!repo.existsById(id)){
            throw new NotFoundException("Producto no encontrado para elimminar dicho Producto");
        }

        repo.deleteById(id);

    }

  

   
    
    
    
}


