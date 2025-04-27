package com.example.demo.services;

import com.example.demo.DTO.GrupoSanguineoDTO;
import com.example.demo.mapper.GrupoSanguineoMapper.GrupoSanguineoMapper;
import com.example.demo.model.GrupoSanguineo;
import com.example.demo.repository.GrupoSanguineoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GrupoSanguineoService {

    @Autowired
    private GrupoSanguineoRepository repo;

    @Autowired
    private GrupoSanguineoMapper mapper;

    public List<GrupoSanguineoDTO> getAll() {
        List<GrupoSanguineo> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public GrupoSanguineoDTO getById(Long id) {
        GrupoSanguineo entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Grupo sanguíneo no encontrado con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public GrupoSanguineoDTO create(GrupoSanguineoDTO dto) {
        GrupoSanguineo nueva = mapper.toEntity(dto);
        GrupoSanguineo guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public GrupoSanguineoDTO update(Long id, GrupoSanguineoDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Grupo sanguíneo no encontrado con id: " + id
            );
        }
        dto.setId(id);
        GrupoSanguineo toSave = mapper.toEntity(dto);
        GrupoSanguineo actualizado = repo.save(toSave);
        return mapper.toDTO(actualizado);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Grupo sanguíneo no encontrado con id: " + id
            );
        }
        repo.deleteById(id);
    }
}
