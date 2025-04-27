package com.example.demo.services;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.mapper.UbicacionMapper.UbicacionMapper;
import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository repo;

    @Autowired
    private UbicacionMapper mapper;

    public List<UbicacionDTO> getAll() {
        List<Ubicacion> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public UbicacionDTO getById(int id) {
        Ubicacion entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ubicación no encontrada con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public UbicacionDTO create(UbicacionDTO dto) {
        Ubicacion nueva = mapper.toEntity(dto);
        Ubicacion guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public UbicacionDTO update(int id, UbicacionDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ubicación no encontrada con id: " + id
            );
        }
        dto.setId(id);
        Ubicacion toSave = mapper.toEntity(dto);
        Ubicacion actualizada = repo.save(toSave);
        return mapper.toDTO(actualizada);
    }

    public void delete(int id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ubicación no encontrada con id: " + id
            );
        }
        repo.deleteById(id);
    }

    public List<UbicacionDTO> getByItinerario(Long itinerarioId) {
        List<Ubicacion> entidades = repo.findByItinerarioUbicacionesItinerarioId(itinerarioId);
        return mapper.toListDTO(entidades);
    }
}
