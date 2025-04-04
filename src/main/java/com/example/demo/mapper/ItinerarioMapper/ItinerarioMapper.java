package com.example.demo.mapper.ItinerarioMapper;

import java.util.List;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.model.Itinerario;

public interface ItinerarioMapper {
    List<ItinerarioDTO> toListDTO(List<Itinerario>itinerario);

    ItinerarioDTO toDTO(Itinerario itinerario);
}
