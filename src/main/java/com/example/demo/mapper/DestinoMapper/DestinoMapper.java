package com.example.demo.mapper.DestinoMapper;

import java.util.List;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.model.Localizacion;

public interface DestinoMapper {

    List<DestinoDTO> toListDTO(List<Localizacion>destinos);

    DestinoDTO toDTO(Localizacion destino);
}
