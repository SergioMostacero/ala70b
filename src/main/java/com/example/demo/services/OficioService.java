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
        Oficio nueva = new Oficio();
        nueva.setNombre(dto.getNombre());
        nueva.setDescripcion(dto.getDescripcion()); 
    
        Oficio guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }
    

    public OficioDTO update(Long id, OficioDTO dto) {
        Oficio existente = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Oficio no encontrado con id: " + id)
        );

        existente.setNombre(dto.getNombre());
        existente.setDescripcion(dto.getDescripcion());

        Oficio actualizada = repo.save(existente);
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
