package com.example.demo.services;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.mapper.RangoMapper.RangoMapper;
import com.example.demo.model.Rango;
import com.example.demo.repository.RangoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RangoService {

    @Autowired
    private RangoRepository repo;

    @Autowired
    private RangoMapper mapper;

    public List<RangoDTO> getAll() {
        List<Rango> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public RangoDTO getById(Long id) {
        Rango entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Rango no encontrado con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public RangoDTO create(RangoDTO dto) {
        Rango nueva = mapper.toEntity(dto);
        Rango guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public RangoDTO update(Long id, RangoDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Rango no encontrado con id: " + id
            );
        }
        dto.setId(id);
        Rango toSave = mapper.toEntity(dto);
        Rango actualizada = repo.save(toSave);
        return mapper.toDTO(actualizada);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Rango no encontrado con id: " + id
            );
        }
        repo.deleteById(id);
    }
}
