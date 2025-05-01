package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Itinerario;
import com.example.demo.model.ItinerarioUbicacion;

@Repository
public interface ItinerarioUbicacionRepository extends JpaRepository<ItinerarioUbicacion, Long> {
    List<ItinerarioUbicacion> findAllByItinerarioId(Long itinerarioId);
}

