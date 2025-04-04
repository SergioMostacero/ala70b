package com.example.demo.mapper.GrupoSanguineoMapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.model.GrupoSanguineo;

@Component
public class GrupoSanguineoMapperImpl implements GrupoSanguineoMapper{
    
    @Override
    public GrupoSanguineoDTO toDTO(GrupoSanguineo grupoSanguineo){
        GrupoSanguineoDTO grupoSanguineoDTO = new GrupoSanguineoDTO();

        grupoSanguineoDTO.setTipo(grupoSanguineo.getTipo());

        return grupoSanguineoDTO;
    }

    @Override
    public List<GrupoSanguineoDTO> toListDTO(List<GrupoSanguineo>grupoSanguineos){
        List<GrupoSanguineoDTO> grupoSanguineoDTOs = new ArrayList<>();
        for (GrupoSanguineo grupoSanguineo : grupoSanguineos) {
            grupoSanguineoDTOs.add(toDTO(grupoSanguineo));
        }
        return grupoSanguineoDTOs;
    }
}
