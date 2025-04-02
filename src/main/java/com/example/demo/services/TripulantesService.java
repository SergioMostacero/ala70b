package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tripulantes;
import com.example.demo.repository.TripulantesRepository;

@Service
public class TripulantesService {

   @Autowired
   private TripulantesRepository TripulantesRepository;

   public List<Tripulantes> getTripulantess() {
      return TripulantesRepository.findAll();
   }

   public Tripulantes login(String email, String contrasena) {
      return TripulantesRepository.findByEmailAndContrasena(email, contrasena)
          .orElseThrow(() -> new RuntimeException("Tripulantes no encontrado o credenciales incorrectas"));
   }
  
  
   public Tripulantes getTripulantesById(Long id) {
      return TripulantesRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Tripulantes no encontrado con ID: " + id));
   }

   public Tripulantes deleteTripulantesById(Long id) {
      Tripulantes Tripulantes = getTripulantesById(id);
      TripulantesRepository.deleteById(id);
      return Tripulantes;
   }

   public Tripulantes createTripulantes(Tripulantes Tripulantes) {
      return TripulantesRepository.save(Tripulantes);
   }

   public Tripulantes updateTripulantesName(Long id, String newName) {
      Tripulantes Tripulantes = getTripulantesById(id);
      Tripulantes.setNombre(newName);
      return TripulantesRepository.save(Tripulantes);
   }
}
   