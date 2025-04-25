package com.example.demo.services;

import com.example.demo.model.Ubicacion;
import com.example.demo.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> getAll() {
        return ubicacionRepository.findAll();
    }

    public Ubicacion getById(int id) {
        return ubicacionRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ubicación no encontrada con id: " + id));
    }

    public Ubicacion create(Ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    public Ubicacion update(Ubicacion ubicacion) {
        if (!ubicacionRepository.existsById(ubicacion.getId())) {
            throw new RuntimeException("Ubicación no encontrada con id: " + ubicacion.getId());
        }
        return ubicacionRepository.save(ubicacion);
    }

    public void delete(int id) {
        ubicacionRepository.deleteById(id);
    }

    public List<Ubicacion> obtenerUbicacionesPorItinerario(Long itinerarioId) {
        return ubicacionRepository.findByItinerarioUbicacionesItinerarioId(itinerarioId);
    }
}
