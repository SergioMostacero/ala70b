package com.example.demo.mapper.VueloMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Localizacion;

@Component
public class VueloMapperImpl implements VueloMapper{
    
    @Override
    public VueloDTO toDTO(Localizacion vuelo){
        VueloDTO vueloDTO = new VueloDTO();

        vueloDTO.setModelo(vuelo.getModelo());

        return vueloDTO;
    }

    @Override
    public List<VueloDTO> toListDTO(List<Localizacion>vuelos){
        List<VueloDTO> vueloDTOs = new ArrayList<>();
        for (Localizacion vuelo : vuelos) {
            vueloDTOs.add(toDTO(vuelo));
        }
        return vueloDTOs;
    }


}
