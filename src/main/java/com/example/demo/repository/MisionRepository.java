package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Mercancia;
import com.example.demo.model.Mision;

@Repository
public interface MisionRepository extends JpaRepository<Mision, Long> {

}

