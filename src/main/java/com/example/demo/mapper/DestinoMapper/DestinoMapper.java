package com.example.demo.mapper.DestinoMapper;

import java.util.List;
import com.example.demo.DTO.DestinoDTO;
import com.example.demo.model.Destino;

public interface DestinoMapper {

    List<DestinoDTO> toListDTO(List<Destino>destinos);

    DestinoDTO toDTO(Destino destino);
}
