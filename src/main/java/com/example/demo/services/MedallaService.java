package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Medalla;
import com.example.demo.model.Tripulantes;
import com.example.demo.repository.MedallaRepository;
import com.example.demo.repository.TripulantesRepository;

@Service
public class MedallaService {

    @Autowired
    private MedallaRepository medallaRepository;

    @Autowired
    private TripulantesRepository tripulantesRepository;

    public List<Medalla> getAllMedallas() {
        return medallaRepository.findAll();
    }

    public List<Medalla> getMedallasByTripulante(Long tripulanteId) {
        Tripulantes tripulante = tripulantesRepository.findById(tripulanteId)
                .orElseThrow(() -> new RuntimeException("Tripulante no encontrado con ID: " + tripulanteId));

        return tripulante.getMedallas();
    }


    public Medalla createMedalla(Medalla medalla) {
        return medallaRepository.save(medalla);
    }
}
