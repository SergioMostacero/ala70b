package com.example.demo.services;

import com.example.demo.DTO.MedallaDTO;
import com.example.demo.mapper.MedallaMapper.MedallaMapper;
import com.example.demo.model.Medalla;
import com.example.demo.model.Tripulantes;
import com.example.demo.repository.MedallaRepository;
import com.example.demo.repository.TripulantesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedallaService {

    @Autowired
    private MedallaRepository medallaRepository;

    @Autowired
    private TripulantesRepository tripulantesRepository;

    @Autowired
    private MedallaMapper medallaMapper;

    public List<MedallaDTO> getAllMedallas() {
        List<Medalla> medallas = medallaRepository.findAll();
        return medallaMapper.toListDTO(medallas);
    }

    public List<MedallaDTO> getMedallasByTripulante(Long tripulanteId) {
        Tripulantes tripulante = tripulantesRepository.findById(tripulanteId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tripulante no encontrado con ID: " + tripulanteId
            ));
        return medallaMapper.toListDTO(tripulante.getMedallas());
    }

    public MedallaDTO createMedalla(MedallaDTO dto) {
        Medalla entidad = medallaMapper.toEntity(dto);
        Medalla guardada = medallaRepository.save(entidad);
        return medallaMapper.toDTO(guardada);
    }

    public void asignarMedalla(Long tripulanteId, Long medallaId) {
        Tripulantes tripulante = tripulantesRepository.findById(tripulanteId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tripulante no encontrado"));
      
        Medalla medalla = medallaRepository.findById(medallaId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medalla no encontrada"));
      
            if(tripulante.getMedallas().contains(medalla)) {
                throw new ResponseStatusException(
                    HttpStatus.CONFLICT, 
                    "El tripulante ya posee esta medalla"
                );
            }
        tripulante.getMedallas().add(medalla);
        tripulantesRepository.save(tripulante);
      }
}
