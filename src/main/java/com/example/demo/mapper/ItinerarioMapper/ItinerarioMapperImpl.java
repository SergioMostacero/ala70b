package com.example.demo.mapper.ItinerarioMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.model.Itinerario;

@Component
public class ItinerarioMapperImpl implements ItinerarioMapper {

    @Override
    public ItinerarioDTO toDTO(Itinerario itinerario) {
        if (itinerario == null) {
            return null;
        }
        ItinerarioDTO dto = new ItinerarioDTO();
        dto.setId(itinerario.getId());
        dto.setNombre(itinerario.getNombre());
        dto.setDuracion(itinerario.getDuracion());
        // si tuvieras que mapear la lista de ItinerarioUbicacion, iría aquí
        return dto;
    }

    @Override
    public Itinerario toEntity(ItinerarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Itinerario itinerario = new Itinerario();
        itinerario.setId(dto.getId());
        itinerario.setNombre(dto.getNombre());
        itinerario.setDuracion(dto.getDuracion());
        // si tuvieras que crear la lista de ItinerarioUbicacion
        return itinerario;
    }

    @Override
    public List<ItinerarioDTO> toListDTO(List<Itinerario> itinerarios) {
        List<ItinerarioDTO> result = new ArrayList<>();
        if (itinerarios != null) {
            for (Itinerario it : itinerarios) {
                result.add(toDTO(it));
            }
        }
        return result;
    }
}
