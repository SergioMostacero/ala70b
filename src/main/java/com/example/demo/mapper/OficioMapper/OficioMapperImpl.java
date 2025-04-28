package com.example.demo.mapper.OficioMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.model.Oficio;

@Component 
public class OficioMapperImpl implements OficioMapper {
    
    @Override
    public OficioDTO toDTO(Oficio oficio) {
        OficioDTO oficioDTO = new OficioDTO();
        oficioDTO.setId(oficio.getId()); 
        oficioDTO.setNombre(oficio.getNombre());
        return oficioDTO;
    }

    @Override
    public Oficio toEntity(OficioDTO dto) {
        if (dto == null) {
            return null;
        }
        Oficio oficio = new Oficio();
        oficio.setId(dto.getId());     
        oficio.setNombre(dto.getNombre());
        return oficio;
    }

    @Override
    public List<OficioDTO> toListDTO(List<Oficio> oficios) {
        List<OficioDTO> oficioDTOs = new ArrayList<>(); // Corregir nombre variable
        for (Oficio oficio : oficios) {
            oficioDTOs.add(toDTO(oficio));
        }
        return oficioDTOs;
    }
}