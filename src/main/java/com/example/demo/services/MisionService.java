package com.example.demo.services;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.mapper.MisionMapper.MisionMapper;
import com.example.demo.model.Mision;
import com.example.demo.repository.MisionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MisionService {

    @Autowired
    private MisionRepository repo;

    @Autowired
    private MisionMapper mapper;

    public List<MisionDTO> getAll() {
        List<Mision> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public MisionDTO getById(Long id) {
        Mision entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Misión no encontrada con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public MisionDTO create(MisionDTO dto) {
        Mision nueva = mapper.toEntity(dto);
        Mision guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public MisionDTO update(Long id, MisionDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Misión no encontrada con id: " + id
            );
        }
        dto.setId(id);
        Mision toSave = mapper.toEntity(dto);
        Mision actualizado = repo.save(toSave);
        return mapper.toDTO(actualizado);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Misión no encontrada con id: " + id
            );
        }
        repo.deleteById(id);
    }
}
