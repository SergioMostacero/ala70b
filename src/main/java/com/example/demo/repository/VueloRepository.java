package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vuelo;

import jakarta.transaction.Transactional;
@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long>{
}
