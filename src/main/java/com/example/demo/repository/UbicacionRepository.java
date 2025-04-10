package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ubicacion;

import io.micrometer.core.instrument.Meter.Id;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer> {
}
