package com.example.demo.services;

import com.example.demo.DTO.OficioDTO;
import com.example.demo.mapper.OficioMapper.OficioMapper;
import com.example.demo.model.Oficio;
import com.example.demo.repository.OficioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OficioService {

    @Autowired
    private OficioRepository repo;

    @Autowired
    private OficioMapper mapper;

    public List<OficioDTO> getAll() {
        List<Oficio> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public OficioDTO getById(Long id) {
        Oficio entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Oficio no encontrado con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public OficioDTO create(OficioDTO dto) {
        Oficio nueva = mapper.toEntity(dto);
        Oficio guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public OficioDTO update(Long id, OficioDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Oficio no encontrado con id: " + id
            );
        }
        dto.setId(id);
        Oficio toSave = mapper.toEntity(dto);
        Oficio actualizada = repo.save(toSave);
        return mapper.toDTO(actualizada);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Oficio no encontrado con id: " + id
            );
        }
        repo.deleteById(id);
    }
}
