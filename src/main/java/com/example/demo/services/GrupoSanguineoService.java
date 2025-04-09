package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.model.GrupoSanguineo;
import com.example.demo.repository.GrupoSanguineoRepository;

@Service
public class GrupoSanguineoService {
    

    @Autowired
    private GrupoSanguineoRepository GrupoSanguineoRepository;

    public List<GrupoSanguineoDTO> getAllGrupoSanguineos() {
        return GrupoSanguineoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public GrupoSanguineoDTO getGrupoSanguineoById(Long id) {
        return GrupoSanguineoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("GrupoSanguineo no encontrado"));
    }

    public GrupoSanguineoDTO createGrupoSanguineo(GrupoSanguineoDTO GrupoSanguineoDTO) {
        GrupoSanguineo GrupoSanguineo = convertToEntity(GrupoSanguineoDTO);
        return convertToDTO(GrupoSanguineoRepository.save(GrupoSanguineo));
    }

    public GrupoSanguineoDTO updateGrupoSanguineo(Long id, GrupoSanguineoDTO GrupoSanguineoDTO) {
        GrupoSanguineo GrupoSanguineo = GrupoSanguineoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GrupoSanguineo no encontrado"));
        GrupoSanguineo.setTipo(GrupoSanguineoDTO.getTipo());
        return convertToDTO(GrupoSanguineoRepository.save(GrupoSanguineo));
    }

    public void deleteGrupoSanguineo(Long id) {
        GrupoSanguineoRepository.deleteById(id);
    }

    private GrupoSanguineoDTO convertToDTO(GrupoSanguineo GrupoSanguineo) {
        GrupoSanguineoDTO dto = new GrupoSanguineoDTO();
        dto.setId(GrupoSanguineo.getId());
        dto.setTipo(GrupoSanguineo.getTipo());
        return dto;
    }

    private GrupoSanguineo convertToEntity(GrupoSanguineoDTO dto) {
        GrupoSanguineo GrupoSanguineo = new GrupoSanguineo();
        GrupoSanguineo.setTipo(dto.getTipo());
        return GrupoSanguineo;
    }
}
