package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

import jakarta.transaction.Transactional;

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

    public List<TripulantesDTO> getAll() {
      List<Tripulantes> entidades = tripulantesRepository.findAll();
      return tripulantesMapper.toListDTO(entidades);
  }

  public TripulantesDTO login(String email, String contrasena) {
      Tripulantes entidad = tripulantesRepository
          .findByEmailAndContrasena(email, contrasena)
          .orElseThrow(() -> new ResponseStatusException(
              HttpStatus.UNAUTHORIZED,
              "Credenciales incorrectas"
          ));
      return tripulantesMapper.toDTO(entidad);
  }

  public TripulantesDTO getById(Long id) {
      Tripulantes entidad = tripulantesRepository.findById(id)
          .orElseThrow(() -> new ResponseStatusException(
              HttpStatus.NOT_FOUND,
              "Tripulante no encontrado con id: " + id
          ));
      return tripulantesMapper.toDTO(entidad);
  }

  @Transactional
  public TripulantesDTO createTripulantes(TripulantesDTO dto) {
  
      Tripulantes entity = tripulantesMapper.toEntity(dto);
      entity.setGrupoSanguineo(
          grupoSanguineoRepository.findById(dto.getGrupoSanguineoDTO().getId())
              .orElseThrow(() -> new ResponseStatusException(
                  HttpStatus.BAD_REQUEST, "Grupo sanguíneo no encontrado"))
      );
      entity.setRango(
          rangoRepository.findById(dto.getRangoDTO().getId())
              .orElseThrow(() -> new ResponseStatusException(
                  HttpStatus.BAD_REQUEST, "Rango no encontrado"))
      );
      entity.setOficio(
          oficioRepository.findById(dto.getOficioDTO().getId())
              .orElseThrow(() -> new ResponseStatusException(
                  HttpStatus.BAD_REQUEST, "Oficio no encontrado"))
      );
      Tripulantes saved = tripulantesRepository.save(entity);

      return tripulantesMapper.toDTO(saved);
  }
  

   public TripulantesDTO updateName(Long id, String newName) {
        Tripulantes entidad = tripulantesRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tripulante no encontrado con id: " + id
            ));
        entidad.setNombre(newName);
        Tripulantes updated = tripulantesRepository.save(entidad);
        return tripulantesMapper.toDTO(updated);
    }

    /**
     * Elimina un tripulante por ID
     */
    public void delete(Long id) {
        if (!tripulantesRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tripulante no encontrado con id: " + id
            );
        }
        tripulantesRepository.deleteById(id);
    
   }
}
   