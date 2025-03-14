package com.example.demo.mapper.DestinoMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.model.Destino;

@Component
public class DestinoMapperImpl implements DestinoMapper{
    
    @Override
    public DestinoDTO toDTO(Destino destino){
        DestinoDTO destinoDTO = new DestinoDTO();

        destinoDTO.setNombre(destino.getNombre());

        return destinoDTO;
    }

    @Override
    public List<DestinoDTO> toListDTO(List<Destino>destinos){
        List<DestinoDTO> destinoDTOs = new ArrayList<>();
        for (Destino destino : destinos) {
            destinoDTOs.add(toDTO(destino));
        }
        return destinoDTOs;
    }


}
