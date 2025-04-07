package com.example.demo.mapper.OficioMapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.model.Oficio;

public class OficioMapperImpl implements OficioMapper{
    @Override
    public OficioDTO toDTO(Oficio oficio){
        OficioDTO oficioDTO = new OficioDTO();

        oficioDTO.setNombre(oficio.getNombre());

        return oficioDTO;
    }

    @Override
    public List<OficioDTO> toListDTO(List<Oficio>oficios){
        List<OficioDTO> medallaDTOs = new ArrayList<>();
        for (Oficio oficio : oficios) {
            medallaDTOs.add(toDTO(oficio));
        }
        return medallaDTOs;
    }

}
