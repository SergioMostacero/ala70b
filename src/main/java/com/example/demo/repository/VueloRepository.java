package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Vuelo;
@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long>{
    boolean existsByModelo(String modelo);

}
