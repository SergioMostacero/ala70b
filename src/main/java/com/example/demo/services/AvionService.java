package com.example.demo.services;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.mapper.AvionMapper.AvionMapper;
import com.example.demo.model.Avion;
import com.example.demo.repository.AvionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private AvionMapper avionMapper;

    public List<AvionDTO> getAll() {
        List<Avion> aviones = avionRepository.findAll();
        return avionMapper.toListDTO(aviones);
    }

    public AvionDTO getById(Long id) {
        Avion avion = avionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                  HttpStatus.NOT_FOUND,
                  "Avión no encontrado con id: " + id
            ));
        return avionMapper.toDTO(avion);
    }

    public AvionDTO createAvion(AvionDTO dto) {
        Avion nuevo = avionMapper.toEntity(dto);
        Avion guardado = avionRepository.save(nuevo);
        return avionMapper.toDTO(guardado);
    }

    public AvionDTO updateAvion(AvionDTO dto) {
        if (!avionRepository.existsById(dto.getId())) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Avión no encontrado con id: " + dto.getId()
            );
        }
        Avion toSave = avionMapper.toEntity(dto);
        Avion actualizado = avionRepository.save(toSave);
        return avionMapper.toDTO(actualizado);
    }

    public void deleteAvion(Long id) {
        if (!avionRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Avión no encontrado con id: " + id
            );
        }
        avionRepository.deleteById(id);
    }
}
