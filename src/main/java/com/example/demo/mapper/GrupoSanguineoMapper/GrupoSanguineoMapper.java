package com.example.demo.mapper.GrupoSanguineoMapper;

import java.util.List;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.model.GrupoSanguineo;

public interface GrupoSanguineoMapper {

    List<GrupoSanguineoDTO> toListDTO(List<GrupoSanguineo>grupoSanguineo);
    GrupoSanguineo toEntity(GrupoSanguineoDTO dto);
    GrupoSanguineoDTO toDTO(GrupoSanguineo grupoSanguineo);
}