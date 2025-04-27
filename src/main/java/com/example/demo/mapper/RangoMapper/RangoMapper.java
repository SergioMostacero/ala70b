package com.example.demo.mapper.RangoMapper;

import java.util.List;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.model.Rango;

public interface RangoMapper {

    List<RangoDTO> toListDTO(List<Rango>rangos);
    Rango toEntity(RangoDTO dto);
    RangoDTO toDTO(Rango rango);
}
