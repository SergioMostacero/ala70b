package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Destino;
import com.example.demo.repository.DestinoRepository;


@Service
public class DestinoService {

   @Autowired
   private DestinoRepository destinoRepository;


   public List<Destino> getDestinos(){
      return destinoRepository.findAll();
   }

   public Destino getDestinoById(Long id){
      return destinoRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Destino no encontrado con ID: AAAAAAAAAAAAAAAY QUE ME CAGO" + id));
   }

   public Destino deleteDestinoById(Long id){
      Destino destino = getDestinoById(id);
      destinoRepository.deleteById(id);
      return destino;
   }
   //añadir destino para añadir con un fich img la foto y el nombre dle pais
   public Destino createDestino(Destino destino){
      return destinoRepository.save(destino);
   }

   public Destino updateDestinoName(Long id, String newName){
      Destino destino = getDestinoById(id);
      destino.setNombre(newName);
      return destinoRepository.save(destino);
   }


public Destino deleteDestinoAdmin(Long destinoId, Long roleId) {
    Destino destino = getDestinoById(destinoId);
    destinoRepository.deleteById(destinoId);
    return destino;
}
}