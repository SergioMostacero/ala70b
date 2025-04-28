package com.example.demo.mapper.GrupoSanguineoMapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.GrupoSanguineo;

@Component
public class GrupoSanguineoMapperImpl implements GrupoSanguineoMapper{
    
    @Override
    public GrupoSanguineoDTO toDTO(GrupoSanguineo grupoSanguineo){
        GrupoSanguineoDTO grupoSanguineoDTO = new GrupoSanguineoDTO();
        grupoSanguineoDTO.setId(grupoSanguineo.getId());
        grupoSanguineoDTO.setTipo(grupoSanguineo.getTipo());
        return grupoSanguineoDTO;
    }

     @Override
    public GrupoSanguineo toEntity(GrupoSanguineoDTO dto) {
        if (dto == null) {
            return null;
        }
        GrupoSanguineo grupoSanguineo = new GrupoSanguineo();
        grupoSanguineo.setId(dto.getId());     
        grupoSanguineo.setTipo(dto.getTipo());
        return grupoSanguineo;
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
