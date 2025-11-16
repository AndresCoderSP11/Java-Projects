package com.todocodeacademy.pruebatecsupermercado.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todocodeacademy.pruebatecsupermercado.dto.SucursalDTO;
import com.todocodeacademy.pruebatecsupermercado.exception.NotFoundException;
import com.todocodeacademy.pruebatecsupermercado.mapper.Mapper;
import com.todocodeacademy.pruebatecsupermercado.model.Sucursal;
import com.todocodeacademy.pruebatecsupermercado.repository.SucursalRepository;

@Service
public class SucursalService implements ISucursalService{

    @Autowired
    private SucursalRepository repo;

    @Override
    public List<SucursalDTO> traerSucursales() {
        // TODO Auto-generated method stub
        
        return repo.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public SucursalDTO crearSucursal(SucursalDTO sucursalDto) {
        
        var sucur=Sucursal.builder()
                    .nombre(sucursalDto.getNombre())
                    .direccion(sucursalDto.getDireccion())
                    .build();
        return Mapper.toDTO(repo.save(sucur));
    }

    @Override
    public SucursalDTO actualizarSucursal(Long id, SucursalDTO sucursalDto) {
       Sucursal sucur=repo.findById(id).orElseThrow(()->new NotFoundException("Sucursal no encontrada"));

       sucur.setNombre(sucursalDto.getNombre());
       sucur.setDireccion(sucursalDto.getDireccion());
        
       return Mapper.toDTO(repo.save(sucur));
    }

    @Override
    public void eliminarSucursal(Long id) {
        
        if(!repo.existsById(id)){
            new NotFoundException("No existe el sucursal");
        }
        repo.deleteById(id);
    }
    
}
