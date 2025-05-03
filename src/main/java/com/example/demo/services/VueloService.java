package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.DTO.TripulantesDTO;
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

     public List<VueloDTO> getAll() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        return vueloMapper.toListDTO(vuelos);
    }

    public VueloDTO getById(Long id) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Vuelo no encontrado con id: " + id
            ));
        return vueloMapper.toDTO(vuelo);
    }

    public VueloDTO createVuelo(VueloDTO dto) {
        Avion avion = avionRepository.findById(dto.getAvionDTO().getId())
            .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
        Mision mision = misionRepository.findById(dto.getMisionDTO().getId())
            .orElseThrow(() -> new RuntimeException("Misión no encontrada"));
        Itinerario itinerario = itinerarioRepository.findById(dto.getItinerarioDTO().getId())
            .orElseThrow(() -> new RuntimeException("Itinerario no encontrado"));
    
        Vuelo vuelo = new Vuelo();
        vuelo.setFecha_salida(dto.getFecha_salida());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setFecha_llegada(dto.getFecha_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setCombustible(dto.getCombustible());
        vuelo.setAvion(avion);
        vuelo.setMisiones(mision);
        vuelo.setItinerario(itinerario);
    
        // Guardamos primero el vuelo sin tripulantes
        vuelo = vueloRepository.save(vuelo);
    
        // Asociar tripulantes si vienen en el DTO
        if (dto.getTripulantesDTO() != null && !dto.getTripulantesDTO().isEmpty()) {
            for (TripulantesDTO tripulanteDTO : dto.getTripulantesDTO()) {
                Tripulantes tripulante = tripulantesRepository.findById(tripulanteDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Tripulante no encontrado"));
                tripulante.getVuelos().add(vuelo);
                tripulantesRepository.save(tripulante);
            }
        }
        
        return vueloMapper.toDTO(vuelo);
    }
    
    

    

    public VueloDTO updateVuelo(Long id, VueloDTO dto) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        // Campos básicos
        vuelo.setFecha_salida(dto.getFecha_salida());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setFecha_llegada(dto.getFecha_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setCombustible(dto.getCombustible());

        // Avion
        if (dto.getAvionDTO() != null && dto.getAvionDTO().getId() != null) {
            Avion avion = avionRepository.findById(dto.getAvionDTO().getId())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
            vuelo.setAvion(avion);
        } else {
            vuelo.setAvion(null);
        }

        // Mision
        if (dto.getMisionDTO() != null && dto.getMisionDTO().getId() != null) {
            Mision mision = misionRepository.findById(dto.getMisionDTO().getId())
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

    public void delete(Long id) {
        if (!vueloRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Vuelo no encontrado con id: " + id
            );
        }
        vueloRepository.deleteById(id);
    }

    public List<VueloDTO> getByTripulanteId(Long tripulanteId) {
        Tripulantes tripulante = tripulantesRepository.findById(tripulanteId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tripulante no encontrado con id: " + tripulanteId
            ));
    
        LocalDate hoy = LocalDate.now();
        boolean actualizado = false;
    
        for (Vuelo vuelo : tripulante.getVuelos()) {
            if (vuelo.getFecha_llegada() != null && 
                !vuelo.isHorasSumadas() &&
                vuelo.getFecha_llegada().isBefore(hoy)) {
    
                Itinerario itinerario = vuelo.getItinerario();
                if (itinerario != null && itinerario.getDuracion() != null) {
                    int horas = itinerario.getDuracion().getHour();
                    int minutos = itinerario.getDuracion().getMinute();
                    double duracionHoras = horas + (minutos / 60.0);
    
                    Double horasTotales = tripulante.getHoras_totales();
                    if (horasTotales == null) horasTotales = 0.0;
    
                    tripulante.setHoras_totales(horasTotales + duracionHoras);
                    vuelo.setHorasSumadas(true);
                    actualizado = true;
                }
            }
        }
    
        if (actualizado) {
            tripulantesRepository.save(tripulante);
            vueloRepository.saveAll(tripulante.getVuelos());
        }
    
        return vueloMapper.toListDTO(tripulante.getVuelos());
    }
    
    

    @Transactional
    public void sumarHorasVuelosRealizados() {
        List<Vuelo> vuelosPendientes = vueloRepository.findAll().stream()
            .filter(v -> v.getFecha_llegada() != null &&
                         v.getFecha_llegada().isBefore(LocalDate.now()) &&
                         !v.isHorasSumadas())
            .toList();
    
        for (Vuelo vuelo : vuelosPendientes) {
            Itinerario itinerario = vuelo.getItinerario();
            if (itinerario != null && itinerario.getDuracion() != null) {
                int horas = itinerario.getDuracion().getHour();
                int minutos = itinerario.getDuracion().getMinute();
                double duracionHoras = horas + (minutos / 60.0);
    
                for (Tripulantes tripulante : vuelo.getTripulantes()) {
                    double actuales = tripulante.getHoras_totales() == null ? 0.0 : tripulante.getHoras_totales();
                    tripulante.setHoras_totales(actuales + duracionHoras);
                    tripulantesRepository.save(tripulante);
                }
    
                vuelo.setHorasSumadas(true);
                vueloRepository.save(vuelo);
            }
        }
    }
    

}