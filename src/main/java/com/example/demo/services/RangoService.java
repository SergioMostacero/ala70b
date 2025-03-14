package com.example.demo.services;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.model.Rango;
import com.example.demo.repository.RangoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RangoService {

    @Autowired
    private RangoRepository rangoRepository;

    public List<RangoDTO> getAllRangos() {
        return rangoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RangoDTO getRangoById(Long id) {
        return rangoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Rango no encontrado"));
    }

    public RangoDTO createRango(RangoDTO rangoDTO) {
        Rango rango = convertToEntity(rangoDTO);
        return convertToDTO(rangoRepository.save(rango));
    }

    public RangoDTO updateRango(Long id, RangoDTO rangoDTO) {
        Rango rango = rangoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rango no encontrado"));
        rango.setNombre(rangoDTO.getNombre());
        rango.setDescripcion(rangoDTO.getDescripcion());
        return convertToDTO(rangoRepository.save(rango));
    }

    public void deleteRango(Long id) {
        rangoRepository.deleteById(id);
    }

    private RangoDTO convertToDTO(Rango rango) {
        RangoDTO dto = new RangoDTO();
        dto.setId(rango.getId());
        dto.setNombre(rango.getNombre());
        dto.setDescripcion(rango.getDescripcion());
        return dto;
    }

    private Rango convertToEntity(RangoDTO dto) {
        Rango rango = new Rango();
        rango.setNombre(dto.getNombre());
        rango.setDescripcion(dto.getDescripcion());
        return rango;
    }
}
