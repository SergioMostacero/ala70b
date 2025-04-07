package com.example.demo.mapper.MisionMapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.model.Mision;

public class MisionMapperImpl implements MisionMapper{
     @Override
    public MisionDTO toDTO(Mision mision){
        MisionDTO medallaDTO = new MisionDTO();

        medallaDTO.setNombre(mision.getNombre());

        return medallaDTO;
    }

    @Override
    public List<MisionDTO> toListDTO(List<Mision>misiones){
        List<MisionDTO> medallaDTOs = new ArrayList<>();
        for (Mision mision : misiones) {
            medallaDTOs.add(toDTO(mision));
        }
        return medallaDTOs;
    }
}
