package com.example.demo.mapper.MisionMapper;

import java.util.List;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.model.Mision;

public interface MisionMapper {
    MisionDTO toDTO(Mision mision);
    Mision toEntity(MisionDTO dto);
    List<MisionDTO> toListDTO(List<Mision> misiones);
}
