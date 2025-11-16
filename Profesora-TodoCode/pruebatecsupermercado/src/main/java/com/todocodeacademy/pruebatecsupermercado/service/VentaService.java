package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.pruebatecsupermercado.dto.DetalleVentaDTO;
import com.todocodeacademy.pruebatecsupermercado.dto.VentaDTO;
import com.todocodeacademy.pruebatecsupermercado.exception.NotFoundException;
import com.todocodeacademy.pruebatecsupermercado.mapper.Mapper;
import com.todocodeacademy.pruebatecsupermercado.model.DetalleVenta;
import com.todocodeacademy.pruebatecsupermercado.model.Producto;
import com.todocodeacademy.pruebatecsupermercado.model.Sucursal;
import com.todocodeacademy.pruebatecsupermercado.model.Venta;
import com.todocodeacademy.pruebatecsupermercado.repository.ProductoRepository;
import com.todocodeacademy.pruebatecsupermercado.repository.SucursalRepository;
import com.todocodeacademy.pruebatecsupermercado.repository.VentaRepository;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository ventaRepo;

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private SucursalRepository sucursalRepo;

    @Override
    public List<VentaDTO> traerVentas() {

        List<Venta> ventas = ventaRepo.findAll();
        List<VentaDTO> ventasDto = new ArrayList<>();

        VentaDTO dto;
        for (Venta v : ventas) {
            dto = Mapper.toDTO(v);
            ventasDto.add(dto);
        }

        return ventasDto;
    }

    @Override
    public VentaDTO crearVenta(VentaDTO ventaDto) {

        if (ventaDto == null)
            throw new RuntimeException("VentaDTO es null");
        if (ventaDto.getIdSucursal() == null)
            throw new RuntimeException("Debe indicar la sucursal");
        if (ventaDto.getDetalle() == null || ventaDto.getDetalle().isEmpty()) {
            throw new RuntimeException("Debe incluir al menos un producto");
        }

        // Buscar la sucursal

        Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal()).orElse(null);
        if (suc == null) {
            throw new NotFoundException("Sucursal no encontrada");
        }
        // Crear la venta

        Venta vent = new Venta();

        vent.setTotal(ventaDto.getTotal());
        vent.setEstado(ventaDto.getEstado());
        vent.setFecha(ventaDto.getFecha());
        vent.setSucursal(suc);
        // La lista de detalles

        List<DetalleVenta> detalles = new ArrayList<>();

        for (DetalleVentaDTO detDTO : ventaDto.getDetalle()) {
            // Buscar product por id (tu detTO usa id como id de producto)
            Producto p = productoRepo.findByNombre(detDTO.getNombreProd()).orElse(null);
            if (p == null) {
                throw new RuntimeException("Producto no encontrado" + detDTO.getNombreProd());
            }

            DetalleVenta detalleVent = new DetalleVenta();
            detalleVent.setProd(p);
            detalleVent.setPrecio(detDTO.getPrecio());
            detalleVent.setCantProd(detDTO.getCantProd());
            detalleVent.setVenta(vent);
            // Agregar la aprte de Arreglo
            detalles.add(detalleVent);
        }

        vent.setDetalle(detalles);

        ventaRepo.save(vent);

        VentaDTO ventaSalida = Mapper.toDTO(vent);

        return ventaSalida;

        // Aqui estan todos los productos

    }

    @Override
    public VentaDTO aztualizarVenta(Long id, VentaDTO ventaDto) {
        Venta v = ventaRepo.findById(id).orElse(null);
        if (v == null) {
            throw new RuntimeException("Venta no encontradaq");
        }

        if(ventaDto.getFecha()!=null){
            v.setFecha(ventaDto.getFecha());
        }
        if(ventaDto.getEstado()!=null){
            v.setEstado(ventaDto.getEstado());
        }

        if(ventaDto.getTotal()!=null){
            v.setTotal(ventaDto.getTotal());
        }

        if(ventaDto.getIdSucursal()!=null){
            Sucursal suc = sucursalRepo.findById(ventaDto.getIdSucursal()).orElse(null);
            if(suc ==null) throw new NotFoundException("Sucursal no encontrada");
            v.setSucursal(suc);
        }

        ventaRepo.save(v);

        VentaDTO ventaSalida=Mapper.toDTO(v);

        return ventaSalida;
    }

    @Override
    public void eliminarVenta(Long id) {
        Venta v = ventaRepo.findById(id).orElse(null);
        if (v == null) {
            throw new RuntimeException("Venta no encontradaq");
        }

        
    }

}
