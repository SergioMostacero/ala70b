package com.example.demo.mapper.TripulantesMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.model.Tripulantes;

@Component
public class TripulantesMapperImpl implements TripulantesMapper{
    
    @Override
    public TripulantesDTO toDTO(Tripulantes Tripulantes){
        TripulantesDTO TripulantesDTO = new TripulantesDTO();

        TripulantesDTO.setNombre(Tripulantes.getNombre());

        return TripulantesDTO;
    }

    @Override
    public List<TripulantesDTO> toListDTO(List<Tripulantes>Tripulantess){
        List<TripulantesDTO> TripulantesDTOs = new ArrayList<>();
        for (Tripulantes Tripulantes : Tripulantess) {
            TripulantesDTOs.add(toDTO(Tripulantes));
        }
        return TripulantesDTOs;
    }


}
