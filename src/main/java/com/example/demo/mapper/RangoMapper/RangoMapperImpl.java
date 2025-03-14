package com.example.demo.mapper.RangoMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.model.Rango;

@Component
public class RangoMapperImpl implements RangoMapper{
    
    @Override
    public RangoDTO toDTO(Rango rango){
        RangoDTO rangoDTO = new RangoDTO();

        rangoDTO.setNombre(rango.getNombre());

        return rangoDTO;
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
