package com.example.demo.mapper.VueloMapper;

import java.util.List;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Localizacion;

public interface VueloMapper {

    List<VueloDTO> toListDTO(List<Localizacion>vuelos);

    VueloDTO toDTO(Localizacion vuelo);
}
