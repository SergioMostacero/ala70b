package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tripulantes;

@Repository
public interface TripulantesRepository extends JpaRepository<Tripulantes,Long>{
    boolean existsByNombre(String nombre);
    Optional<Tripulantes> findByEmail(String email);
    Optional<Tripulantes> findByEmailAndContrasena(String email, String contrasena);
    List<Tripulantes> findByOficioNombreIgnoreCase(String nombre);


}
