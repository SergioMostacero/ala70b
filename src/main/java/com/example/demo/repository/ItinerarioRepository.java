package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Itinerario;

@Repository
public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

}
