package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Oficio;

@Repository
public interface OficioRepository extends JpaRepository<Oficio, Long> {

}
