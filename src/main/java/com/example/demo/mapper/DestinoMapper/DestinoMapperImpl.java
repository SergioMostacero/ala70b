package com.example.demo.mapper.DestinoMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.model.Localizacion;

@Component
public class DestinoMapperImpl implements DestinoMapper{
    
    @Override
    public DestinoDTO toDTO(Localizacion destino){
        DestinoDTO destinoDTO = new DestinoDTO();

        destinoDTO.setNombre(destino.getNombre());

        return destinoDTO;
    }

    @Override
    public List<DestinoDTO> toListDTO(List<Localizacion>destinos){
        List<DestinoDTO> destinoDTOs = new ArrayList<>();
        for (Localizacion destino : destinos) {
            destinoDTOs.add(toDTO(destino));
        }
        return destinoDTOs;
    }


}
