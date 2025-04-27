package com.example.demo.mapper.OficioMapper;

import java.util.List;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.OficioDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Oficio;



public interface OficioMapper {
    List<OficioDTO> toListDTO(List<Oficio>oficio);
    Oficio toEntity(OficioDTO dto);
    OficioDTO toDTO(Oficio oficio);
}
