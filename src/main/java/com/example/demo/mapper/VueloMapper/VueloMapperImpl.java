package com.example.demo.mapper.VueloMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Vuelo;

@Component
public class VueloMapperImpl implements VueloMapper{
    
    @Override
    public VueloDTO toDTO(Vuelo vuelo){
        VueloDTO vueloDTO = new VueloDTO();

        vueloDTO.setModelo(vuelo.getModelo());

        return vueloDTO;
    }

    @Override
    public List<VueloDTO> toListDTO(List<Vuelo>vuelos){
        List<VueloDTO> vueloDTOs = new ArrayList<>();
        for (Vuelo vuelo : vuelos) {
            vueloDTOs.add(toDTO(vuelo));
        }
        return vueloDTOs;
    }


}
