package com.example.demo.services;

import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.mapper.ItinerarioMapper.ItinerarioMapper;
import com.example.demo.model.Itinerario;
import com.example.demo.repository.ItinerarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository repo;

    @Autowired
    private ItinerarioMapper mapper;

    public List<ItinerarioDTO> getAll() {
        List<Itinerario> entidades = repo.findAll();
        return mapper.toListDTO(entidades);
    }

    public ItinerarioDTO getById(Long id) {
        Itinerario entidad = repo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            ));
        return mapper.toDTO(entidad);
    }

    public ItinerarioDTO create(ItinerarioDTO dto) {
        Itinerario nueva = mapper.toEntity(dto);
        Itinerario guardada = repo.save(nueva);
        return mapper.toDTO(guardada);
    }

    public ItinerarioDTO update(Long id, ItinerarioDTO dto) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            );
        }
        dto.setId(id);
        Itinerario toSave = mapper.toEntity(dto);
        Itinerario actualizado = repo.save(toSave);
        return mapper.toDTO(actualizado);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Itinerario no encontrado con id: " + id
            );
        }
        repo.deleteById(id);
    }
}
