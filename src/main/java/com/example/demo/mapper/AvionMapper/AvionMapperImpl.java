package com.example.demo.mapper.AvionMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.model.Avion;

@Component
public class AvionMapperImpl implements AvionMapper {

    @Override
    public AvionDTO toDTO(Avion avion) {
        if (avion == null) {
            return null;
        }
        AvionDTO dto = new AvionDTO();
        dto.setId(avion.getId());
        dto.setNombre(avion.getNombre());
        dto.setMax_combustible(avion.getMax_combustible());
        return dto;
    }

    @Override
    public Avion toEntity(AvionDTO dto) {
        if (dto == null) {
            return null;
        }
        Avion avion = new Avion();
        avion.setId(dto.getId());     
        avion.setNombre(dto.getNombre());
        avion.setMax_combustible(dto.getMax_combustible());
        return avion;
    }

    @Override
    public List<AvionDTO> toListDTO(List<Avion> aviones) {
        List<AvionDTO> result = new ArrayList<>();
        if (aviones != null) {
            for (Avion avion : aviones) {
                result.add(toDTO(avion));
            }
        }
        return result;
    }
}
