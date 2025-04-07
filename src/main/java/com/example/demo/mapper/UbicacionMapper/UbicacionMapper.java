package com.example.demo.mapper.UbicacionMapper;

import java.util.List;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.model.Ubicacion;



public interface UbicacionMapper {
    List<UbicacionDTO> toListDTO(List<Ubicacion>ubicacion);

    UbicacionDTO toDTO(Ubicacion ubicacion);
}
