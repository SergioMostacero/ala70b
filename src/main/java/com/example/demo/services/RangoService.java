package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rango;
import com.example.demo.repository.RangoRepository;


@Service
public class RangoService {

   @Autowired
   private RangoRepository rangoRepository;



   public List<Rango> getRangos(){
      return rangoRepository.findAll();
   }

   public Rango getRangoById(Long id) {
      return rangoRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Rango no encontrado con ID: " + id));
   }

   public Rango deleteRangoById(Long id){
      Rango rango = getRangoById(id);
      rangoRepository.deleteById(id);
      return rango;
   }
   //añadir rango para añadir con un fich img la foto y el nombre dle pais
   public Rango createRango(Rango rango){
      return rangoRepository.save(rango);
   }

   public Rango updateRangoName(Long id, String newName){
      Rango rango = getRangoById(id);
      rango.setNombre(newName);
      return rangoRepository.save(rango);
   }

   public Rango deleteRangoAdmin(Long rangoId, Long roleId) {
      // Verificar si el usuario tiene el rol de administrador
      Rango rango = getRangoById(rangoId);
      rangoRepository.deleteById(rangoId);
      return rango;
   }
}
