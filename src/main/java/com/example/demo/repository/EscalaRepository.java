package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Escalas;

@Repository
public interface EscalaRepository extends JpaRepository<Escalas, Long> {

}

