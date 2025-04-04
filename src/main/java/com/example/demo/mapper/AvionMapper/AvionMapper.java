package com.example.demo.mapper.AvionMapper;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.DTO.AvionDTO;
import com.example.demo.model.Avion;

public interface AvionMapper {
    List<AvionDTO> toListDTO(List<Avion>aviones);

    AvionDTO toDTO(Avion avion);
}

