package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tripulantes;
import com.example.demo.repository.TripulantesRepository;

@Service
public class TripulantesService {

   @Autowired
   private TripulantesRepository tripulantesRepository;

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

   public Tripulantes createTripulantes(Tripulantes tripulantes) {
      return tripulantesRepository.save(tripulantes);
   }

   public Tripulantes updateTripulantesName(Long id, String newName) {
      Tripulantes tripulantes = getTripulantesById(id);
      tripulantes.setNombre(newName);
      return tripulantesRepository.save(tripulantes);
   }
}
   