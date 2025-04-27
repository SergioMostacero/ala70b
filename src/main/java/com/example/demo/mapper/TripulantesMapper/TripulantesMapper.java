package com.example.demo.mapper.TripulantesMapper;

import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Tripulantes;

public interface TripulantesMapper {
    
    List<TripulantesDTO> toListDTO(List<Tripulantes>Tripulantess);
    Tripulantes toEntity(TripulantesDTO dto);
    TripulantesDTO toDTO(Tripulantes Tripulantes);
}
