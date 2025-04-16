package com.example.demo.services;

import com.example.demo.model.Avion;
import com.example.demo.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvionService {

    @Autowired
    private AvionRepository avionRepository;

    public List<Avion> getAll() {
        return avionRepository.findAll();
    }

    public Avion getById(Long id) {
        return avionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Avión no encontrado con id: " + id));
    }

    public Avion create(Avion avion) {
        return avionRepository.save(avion);
    }

    public Avion update(Avion avion) {
        if (!avionRepository.existsById(avion.getId())) {
            throw new RuntimeException("Avión no encontrado con id: " + avion.getId());
        }
        return avionRepository.save(avion);
    }

    public void delete(Long id) {
        avionRepository.deleteById(id);
    }
}
