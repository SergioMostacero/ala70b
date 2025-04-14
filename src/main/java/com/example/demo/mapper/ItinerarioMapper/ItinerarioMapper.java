package com.example.demo.mapper.ItinerarioMapper;

import java.util.List;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.model.Itinerario;

public interface ItinerarioMapper {
    ItinerarioDTO toDTO(Itinerario itinerario);
    Itinerario toEntity(ItinerarioDTO dto);
    List<ItinerarioDTO> toListDTO(List<Itinerario> itinerarios);
}
