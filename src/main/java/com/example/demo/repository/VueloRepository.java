package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Localizacion;
@Repository
public interface VueloRepository extends JpaRepository<Localizacion,Long>{
    boolean existsByModelo(String modelo);

}
