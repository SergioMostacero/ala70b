package com.example.demo.mapper.UbicacionMapper;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.model.Ubicacion;



public class UbicacionMpperImpl implements UbicacionMapper{
    @Override
    public UbicacionDTO toDTO(Ubicacion ubicacion){
        UbicacionDTO ubicacionDTO = new UbicacionDTO();

        ubicacionDTO.setCiudad(ubicacion.getCiudad());
        return ubicacionDTO;
    }

    @Override
    public List<UbicacionDTO> toListDTO(List<Ubicacion>ubicaciones){
        List<UbicacionDTO> medallaDTOs = new ArrayList<>();
        for (Ubicacion ubicacion : ubicaciones) {
            medallaDTOs.add(toDTO(ubicacion));
        }
        return medallaDTOs;
    }
}
