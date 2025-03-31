package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Mercancia;


@Repository
public interface MercanciaRepository extends JpaRepository<Mercancia, Long> {

}

