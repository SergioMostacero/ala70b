package com.example.demo.mapper.MedallaMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component; // Añadir import

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.MedallaDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Medalla;

@Component
public class MedallaMapperImpl implements MedallaMapper {
    
    @Override
    public MedallaDTO toDTO(Medalla medalla) {
        MedallaDTO medallaDTO = new MedallaDTO();
        medallaDTO.setId(medalla.getId()); // Agregar ID
        medallaDTO.setNombre(medalla.getNombre());
        medallaDTO.setDescripcion(medalla.getDescripcion());
        return medallaDTO;
    }

    @Override
        public Medalla toEntity(MedallaDTO dto) {
            if (dto == null) {
                return null;
            }
            Medalla medalla = new Medalla();
            medalla.setId(dto.getId());     
            medalla.setNombre(dto.getNombre());
            medalla.setDescripcion(dto.getDescripcion());
            return medalla;
        }

    @Override
    public List<MedallaDTO> toListDTO(List<Medalla> medallas) { // Corregir nombre parámetro
        List<MedallaDTO> medallaDTOs = new ArrayList<>();
        for (Medalla medalla : medallas) {
            medallaDTOs.add(toDTO(medalla));
        }
        return medallaDTOs;
    }
}