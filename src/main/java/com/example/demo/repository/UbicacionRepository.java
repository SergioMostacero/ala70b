package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
    List<Ubicacion> findByItinerarioUbicacionesItinerarioId(Long itinerarioId);
    @Query("SELECT DISTINCT u FROM Ubicacion u " +
           "JOIN u.itinerarioUbicaciones iu " +           // Ubicacion -> ItinerarioUbicacion
           "JOIN iu.itinerario i " +                       // ItinerarioUbicacion -> Itinerario
           "JOIN i.vuelos v " +                           // Itinerario -> Vuelo
           "JOIN v.tripulantes t " +                      // Vuelo -> Tripulante
           "WHERE t.id = :tripulanteId")
    List<Ubicacion> findByTripulanteId(@Param("tripulanteId") Long tripulanteId);
    
}
