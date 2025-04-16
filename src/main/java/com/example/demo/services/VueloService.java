package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.mapper.VueloMapper.VueloMapper;
import com.example.demo.model.Avion;
import com.example.demo.model.Itinerario;
import com.example.demo.model.Mision;
import com.example.demo.model.Tripulantes;
import com.example.demo.model.Vuelo;
import com.example.demo.repository.AvionRepository;
import com.example.demo.repository.ItinerarioRepository;
import com.example.demo.repository.MisionRepository;
import com.example.demo.repository.TripulantesRepository;
import com.example.demo.repository.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private MisionRepository misionRepository;

    @Autowired
    private ItinerarioRepository itinerarioRepository;

    @Autowired
    private TripulantesRepository tripulantesRepository;


    @Autowired
    private VueloMapper vueloMapper;

    public List<VueloDTO> getAllVuelos() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        return vueloMapper.toListDTO(vuelos);
    }

    public VueloDTO getVueloById(Long id) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        return vueloMapper.toDTO(vuelo);
    }

    public VueloDTO createVuelo(VueloDTO dto) {
        Avion avion = avionRepository.findById(dto.getAvionDTO().getId())
            .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
        Mision mision = misionRepository.findById(dto.getMisionesDTO().getId())
            .orElseThrow(() -> new RuntimeException("Misión no encontrada"));
        Itinerario itinerario = itinerarioRepository.findById(dto.getItinerarioDTO().getId())
            .orElseThrow(() -> new RuntimeException("Itinerario no encontrado"));
    
        Vuelo vuelo = new Vuelo();
        vuelo.setFecha(dto.getFecha());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setGasolina(dto.getGasolina());
        vuelo.setAvion(avion);
        vuelo.setMisiones(mision);
        vuelo.setItinerario(itinerario);
    
        // Guardamos primero el vuelo sin tripulantes
        vuelo = vueloRepository.save(vuelo);
    
        // Asociar tripulantes si vienen en el DTO
        if (dto.getTripulantes() != null && !dto.getTripulantes().isEmpty()) {
            for (Tripulantes tripulante : dto.getTripulantes()) {
                Tripulantes tripulanteBD = tripulantesRepository.findById(tripulante.getId())
                    .orElseThrow(() -> new RuntimeException("Tripulante no encontrado con ID: " + tripulante.getId()));
                tripulanteBD.getVuelos().add(vuelo);
                tripulantesRepository.save(tripulanteBD);
            }
        }
    
        return vueloMapper.toDTO(vuelo);
    }
    
    

    

    public VueloDTO updateVuelo(Long id, VueloDTO dto) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        // Campos básicos
        vuelo.setFecha(dto.getFecha());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setGasolina(dto.getGasolina());

        // Avion
        if (dto.getAvionDTO() != null && dto.getAvionDTO().getId() != null) {
            Avion avion = avionRepository.findById(dto.getAvionDTO().getId())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
            vuelo.setAvion(avion);
        } else {
            vuelo.setAvion(null);
        }

        // Mision
        if (dto.getMisionesDTO() != null && dto.getMisionesDTO().getId() != null) {
            Mision mision = misionRepository.findById(dto.getMisionesDTO().getId())
                .orElseThrow(() -> new RuntimeException("Misión no encontrada"));
            vuelo.setMisiones(mision);
        } else {
            vuelo.setMisiones(null);
        }

        // Itinerario
        if (dto.getItinerarioDTO() != null && dto.getItinerarioDTO().getId() != null) {
            Itinerario itinerario = itinerarioRepository.findById(dto.getItinerarioDTO().getId())
                .orElseThrow(() -> new RuntimeException("Itinerario no encontrado"));
            vuelo.setItinerario(itinerario);
        } else {
            vuelo.setItinerario(null);
        }

        vuelo = vueloRepository.save(vuelo);
        return vueloMapper.toDTO(vuelo);
    }

    // 5) Eliminar un vuelo
    public void deleteVuelo(Long id) {
        if (!vueloRepository.existsById(id)) {
            throw new RuntimeException("Vuelo no encontrado");
        }
        vueloRepository.deleteById(id);
    }

    public List<VueloDTO> getVuelosByTripulanteId(Long tripulanteId) {
        Tripulantes tripulante = tripulantesRepository.findById(tripulanteId)
            .orElseThrow(() -> new RuntimeException("Tripulante no encontrado"));
    
        List<Vuelo> vuelos = tripulante.getVuelos();
        return vueloMapper.toListDTO(vuelos);
    }
    
}
