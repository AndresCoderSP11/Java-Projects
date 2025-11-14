package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.List;

import com.todocodeacademy.pruebatecsupermercado.dto.SucursalDTO;

public interface ISucursalService {
    List<SucursalDTO> traerSucursales();
    SucursalDTO crearSucursal(SucursalDTO sucursalDto);
    SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto);
    void eliminarSucursal(Long id);
}
