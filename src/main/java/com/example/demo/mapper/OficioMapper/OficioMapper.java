package com.example.demo.mapper.OficioMapper;

import java.util.List;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.model.Oficio;



public interface OficioMapper {
    List<OficioDTO> toListDTO(List<Oficio>oficio);

    OficioDTO toDTO(Oficio oficio);
}
