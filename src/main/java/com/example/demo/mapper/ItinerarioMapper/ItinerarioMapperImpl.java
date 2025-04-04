package com.example.demo.mapper.ItinerarioMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.model.Itinerario;


@Component
public class ItinerarioMapperImpl implements ItinerarioMapper{
    @Override
    public ItinerarioDTO toDTO(Itinerario itinerario){
        ItinerarioDTO itinerarioDTO = new ItinerarioDTO();

        itinerarioDTO.setNombre(itinerario.getNombre());

        return itinerarioDTO;
    }

    @Override
    public List<ItinerarioDTO> toListDTO(List<Itinerario>itinerarios){
        List<ItinerarioDTO> itinerarioDTOs = new ArrayList<>();
        for (Itinerario itinerario : itinerarios) {
            itinerarioDTOs.add(toDTO(itinerario));
        }
        return itinerarioDTOs;
    }
}
