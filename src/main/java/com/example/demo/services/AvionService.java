package com.example.demo.services;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.mapper.AvionMapper.AvionMapper;
import com.example.demo.model.Avion;
import com.example.demo.model.Vuelo;
import com.example.demo.repository.AvionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.example.demo.repository.VueloRepository;

import jakarta.transaction.Transactional;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private  VueloService vueloService;

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
    // Obtener el avión existente de la base de datos
    Avion existingAvion = avionRepository.findById(dto.getId())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Avión no encontrado con id: " + dto.getId()
        ));
    
    // Actualizar solo los campos necesarios del DTO
    existingAvion.setNombre(dto.getNombre());
    existingAvion.setMax_combustible(dto.getMax_combustible());
    
    Avion actualizado = avionRepository.save(existingAvion);
    return avionMapper.toDTO(actualizado);
}

    @Transactional
    public void deleteAvion(Long id) {

        Avion avion = avionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Avión no encontrado con id: " + id));

        for (Vuelo v : List.copyOf(avion.getVuelos())) {   
            vueloService.delete(v.getId());                
        }

        avionRepository.delete(avion);      
    }

}
