package com.example.demo.services;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.mapper.UbicacionMapper.UbicacionMapper;
import com.example.demo.model.Itinerario;
import com.example.demo.model.Tripulantes;
import com.example.demo.model.Ubicacion;
import com.example.demo.model.Vuelo;
import com.example.demo.repository.TripulantesRepository;
import com.example.demo.repository.UbicacionRepository;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository repo;

    @Autowired
    private TripulantesRepository tripulanteRepository;

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

    public List<UbicacionDTO> getByTripulante(Long tripulanteId) {
        Tripulantes tripulante = tripulanteRepository.findById(tripulanteId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tripulante no encontrado con id: " + tripulanteId
            ));
    
        Set<Ubicacion> ubicacionesUnicas = new HashSet<>();
        
        // Nuevo: Mapa para controlar duplicados por coordenadas
        Set<String> coordenadasUnicas = new HashSet<>();
        
        for (Vuelo vuelo : tripulante.getVuelos()) {
            Itinerario itinerario = vuelo.getItinerario();
            if (itinerario != null && itinerario.getItinerarioUbicaciones() != null) {
                itinerario.getItinerarioUbicaciones().forEach(iu -> {
                    Ubicacion u = iu.getUbicacion();
                    if (u != null) {
                        String key = u.getLatitud() + "|" + u.getLongitud(); // Clave única
                        if (!coordenadasUnicas.contains(key)) {
                            ubicacionesUnicas.add(u);
                            coordenadasUnicas.add(key);
                        }
                    }
                });
            }
        }
        
        return mapper.toListDTO(new ArrayList<>(ubicacionesUnicas));
    }
}
