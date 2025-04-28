package com.example.demo.mapper.RangoMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.RangoDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Rango;

@Component
public class RangoMapperImpl implements RangoMapper{
    
    @Override
    public RangoDTO toDTO(Rango rango){
        RangoDTO rangoDTO = new RangoDTO();
        rangoDTO.setId(rango.getId());
        rangoDTO.setNombre(rango.getNombre());

        return rangoDTO;
    }

    @Override
    public Rango toEntity(RangoDTO dto) {
        if (dto == null) {
            return null;
        }
        Rango rango = new Rango();
        rango.setId(dto.getId());     
        rango.setNombre(dto.getNombre());
        return rango;
    }

    @Override
    public List<RangoDTO> toListDTO(List<Rango>rangos){
        List<RangoDTO> rangoDTOs = new ArrayList<>();
        for (Rango rango : rangos) {
            rangoDTOs.add(toDTO(rango));
        }
        return rangoDTOs;
    }


}
