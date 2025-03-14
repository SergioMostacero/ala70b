package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Rango;
@Repository
public interface RangoRepository extends JpaRepository<Rango,Long>{
    boolean existsByNombre(String nombre);
}
