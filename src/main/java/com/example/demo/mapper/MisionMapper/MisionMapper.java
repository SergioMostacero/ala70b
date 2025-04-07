package com.example.demo.mapper.MisionMapper;

import java.util.List;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.model.Mision;



public interface  MisionMapper {
    List<MisionDTO> toListDTO(List<Mision>mision);

    MisionDTO toDTO(Mision mision);

}
