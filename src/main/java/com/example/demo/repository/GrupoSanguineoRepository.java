package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.GrupoSanguineo;

@Repository
public interface GrupoSanguineoRepository extends JpaRepository<GrupoSanguineo, Long> {

}
