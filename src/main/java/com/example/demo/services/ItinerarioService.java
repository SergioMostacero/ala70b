package com.example.demo.services;

import com.example.demo.model.Itinerario;
import com.example.demo.repository.ItinerarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerarioService {

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    public List<Itinerario> getAll() {
        return itinerarioRepository.findAll();
    }

    public Itinerario getById(Long id) {
        return itinerarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Itinerario no encontrado con id: " + id));
    }

    public Itinerario create(Itinerario itinerario) {
        return itinerarioRepository.save(itinerario);
    }

    public Itinerario update(Itinerario itinerario) {
        if (!itinerarioRepository.existsById(itinerario.getId())) {
            throw new RuntimeException("Itinerario no encontrado con id: " + itinerario.getId());
        }
        return itinerarioRepository.save(itinerario);
    }

    public void delete(Long id) {
        itinerarioRepository.deleteById(id);
    }
}
