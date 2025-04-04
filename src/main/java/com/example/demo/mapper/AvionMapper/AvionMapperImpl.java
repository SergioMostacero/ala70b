package com.example.demo.mapper.AvionMapper;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.model.Avion;
@Component
public class AvionMapperImpl implements AvionMapper{
    
    @Override
    public AvionDTO toDTO(Avion avion){
        AvionDTO avionDTO = new AvionDTO();

        avionDTO.setNombre(avion.getNombre());

        return avionDTO;
    }

    @Override
    public List<AvionDTO> toListDTO(List<Avion>aviones){
        List<AvionDTO> avionDTOs = new ArrayList<>();
        for (Avion avion : aviones) {
            avionDTOs.add(toDTO(avion));
        }
        return avionDTOs;
    }

}
