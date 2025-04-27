package com.example.demo.mapper.MedallaMapper;

import java.util.List;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.MedallaDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Medalla;


public interface MedallaMapper {

    List<MedallaDTO> toListDTO(List<Medalla>medalla);
    Medalla toEntity(MedallaDTO dto);
    MedallaDTO toDTO(Medalla medalla);
}