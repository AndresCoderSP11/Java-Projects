package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.List;

import com.todocodeacademy.pruebatecsupermercado.dto.VentaDTO;

public interface IVentaService {
    List<VentaDTO> traerVentas();
    VentaDTO crearVenta(VentaDTO ventaDto);
    VentaDTO actualizarVenta(Long id, VentaDTO ventaDto);
    void eliminarVenta(Long id);
}
