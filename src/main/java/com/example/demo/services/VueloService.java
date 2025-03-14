package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vuelo;
import com.example.demo.repository.VueloRepository;

@Service
public class VueloService {

   @Autowired
   private VueloRepository vueloRepository;

   public List<Vuelo> getVuelos() {
      return vueloRepository.findAll();
   }

   public Vuelo getVueloById(Long id) {
      return vueloRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Vuelo no encontrado con ID: " + id));
   }

   public Vuelo deleteVueloById(Long id) {
      Vuelo vuelo = getVueloById(id);
      vueloRepository.deleteById(id);
      return vuelo;
   }

   public Vuelo createVuelo(Vuelo vuelo) {
      return vueloRepository.save(vuelo);
   }

   public Vuelo updateVueloName(Long id, String newName) {
      Vuelo vuelo = getVueloById(id);
      vuelo.setAnticipo(newName);
      return vueloRepository.save(vuelo);
   }

   public Vuelo deleteVueloAdmin(Long vueloId, Long roleId) {
      Vuelo vuelo = getVueloById(vueloId);
      vueloRepository.deleteById(vueloId);
      return vuelo;
   }
}