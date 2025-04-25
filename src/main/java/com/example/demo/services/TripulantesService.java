package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TripulantesDTO;
import com.example.demo.mapper.TripulantesMapper.TripulantesMapper;
import com.example.demo.model.GrupoSanguineo;
import com.example.demo.model.Itinerario;
import com.example.demo.model.Medalla;
import com.example.demo.model.Mision;
import com.example.demo.model.Oficio;
import com.example.demo.model.Rango;
import com.example.demo.model.Tripulantes;
import com.example.demo.model.Vuelo;
import com.example.demo.repository.GrupoSanguineoRepository;
import com.example.demo.repository.ItinerarioRepository;
import com.example.demo.repository.MedallaRepository;
import com.example.demo.repository.MisionRepository;
import com.example.demo.repository.OficioRepository;
import com.example.demo.repository.RangoRepository;
import com.example.demo.repository.TripulantesRepository;
import com.example.demo.repository.VueloRepository;

@Service
public class TripulantesService {

   @Autowired
   private TripulantesRepository tripulantesRepository;

   @Autowired
    private GrupoSanguineoRepository grupoSanguineoRepository;

    @Autowired
    private RangoRepository rangoRepository;

    @Autowired
    private OficioRepository oficioRepository;

    @Autowired
    private MedallaRepository medallaRepository;
    
    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private TripulantesMapper tripulantesMapper;

   public List<Tripulantes> getTripulantes() {
      return tripulantesRepository.findAll();
   }

   public Tripulantes login(String email, String contrasena) {
      return tripulantesRepository.findByEmailAndContrasena(email, contrasena)
          .orElseThrow(() -> new RuntimeException("Tripulantes no encontrado o credenciales incorrectas"));
   }
  
  
   public Tripulantes getTripulantesById(Long id) {
      return tripulantesRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Tripulantes no encontrado con ID: " + id));
   }

   public Tripulantes deleteTripulantesById(Long id) {
      Tripulantes tripulantes = getTripulantesById(id);
      tripulantesRepository.deleteById(id);
      return tripulantes;
   }

   public TripulantesDTO createTripulantes(TripulantesDTO tripulantesDTO) {
      GrupoSanguineo grupoSanguineo = grupoSanguineoRepository.findById(tripulantesDTO.getGrupoSanguineoDTO().getId())
            .orElseThrow(() -> new RuntimeException("Grupo Sanguineo no encontrado"));
      Rango rango = rangoRepository.findById(tripulantesDTO.getRangoDTO().getId())
            .orElseThrow(() -> new RuntimeException("Rango no encontrada"));
      Oficio oficio = oficioRepository.findById(tripulantesDTO.getOficioDTO().getId())
            .orElseThrow(() -> new RuntimeException("Itinerario no encontrado"));

      Tripulantes tripulantes = new Tripulantes();
      tripulantes.setNombre(tripulantesDTO.getNombre());
      tripulantes.setApellidos(tripulantesDTO.getApellidos());
      tripulantes.setEmail(tripulantesDTO.getEmail());
      tripulantes.setContrasena(tripulantesDTO.getContrasena());
      tripulantes.setAntiguedad(tripulantesDTO.getAntiguedad());
      tripulantes.setPermisos(tripulantesDTO.getPermisos());
      tripulantes.setHoras_totales(tripulantesDTO.getHoras_totales());
      tripulantes.setGrupoSanguineo(grupoSanguineo);
      tripulantes.setRango(rango);
      tripulantes.setOficio(oficio);      

      tripulantes = tripulantesRepository.save(tripulantes);

      return tripulantesMapper.toDTO(tripulantes);
   }

   public Tripulantes updateTripulantesName(Long id, String newName) {
      Tripulantes tripulantes = getTripulantesById(id);
      tripulantes.setNombre(newName);
      return tripulantesRepository.save(tripulantes);
   }
}
   