package com.example.demo.mapper.MedallaMapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.MedallaDTO;
import com.example.demo.model.Medalla;

public class MedallaMapperImpl implements MedallaMapper{
     @Override
    public MedallaDTO toDTO(Medalla medalla){
        MedallaDTO medallaDTO = new MedallaDTO();

        medallaDTO.setNombre(medalla.getNombre());

        return medallaDTO;
    }

    @Override
    public List<MedallaDTO> toListDTO(List<Medalla>medallas){
        List<MedallaDTO> medallaDTOs = new ArrayList<>();
        for (Medalla medalla : medallas) {
            medallaDTOs.add(toDTO(medalla));
        }
        return medallaDTOs;
    }
}
