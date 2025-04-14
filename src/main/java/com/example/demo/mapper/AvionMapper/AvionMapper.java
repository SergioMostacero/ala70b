package com.example.demo.mapper.AvionMapper;

import java.util.List;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.model.Avion;

public interface AvionMapper {
    AvionDTO toDTO(Avion avion);
    Avion toEntity(AvionDTO dto);
    List<AvionDTO> toListDTO(List<Avion> aviones);
}
