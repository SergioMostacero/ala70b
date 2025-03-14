package com.example.demo.mapper.VueloMapper;

import java.util.List;
import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Vuelo;

public interface VueloMapper {

    List<VueloDTO> toListDTO(List<Vuelo>vuelos);

    VueloDTO toDTO(Vuelo vuelo);
}
