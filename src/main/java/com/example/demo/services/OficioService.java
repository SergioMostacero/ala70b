package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.model.Oficio;
import com.example.demo.repository.OficioRepository;

@Service
public class OficioService {

    @Autowired
    private OficioRepository OficioRepository;

    public List<OficioDTO> getAllOficios() {
        return OficioRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OficioDTO getOficioById(Long id) {
        return OficioRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Oficio no encontrado"));
    }

    public OficioDTO createOficio(OficioDTO oficioDTO) {
        Oficio Oficio = convertToEntity(oficioDTO);
        return convertToDTO(OficioRepository.save(Oficio));
    }

    public OficioDTO updateOficio(Long id, OficioDTO oficioDTO) {
        Oficio Oficio = OficioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Oficio no encontrado"));
        Oficio.setNombre(oficioDTO.getNombre());
        Oficio.setDescripcion(oficioDTO.getDescripcion());
        return convertToDTO(OficioRepository.save(Oficio));
    }

    public void deleteOficio(Long id) {
        OficioRepository.deleteById(id);
    }

    private OficioDTO convertToDTO(Oficio Oficio) {
        OficioDTO dto = new OficioDTO();
        dto.setId(Oficio.getId());
        dto.setNombre(Oficio.getNombre());
        dto.setDescripcion(Oficio.getDescripcion());
        return dto;
    }

    private Oficio convertToEntity(OficioDTO dto) {
        Oficio Oficio = new Oficio();
        Oficio.setNombre(dto.getNombre());
        Oficio.setDescripcion(dto.getDescripcion());
        return Oficio;
    }
}
