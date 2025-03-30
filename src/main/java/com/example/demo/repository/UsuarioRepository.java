package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    boolean existsByNombre(String nombre);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email, String password);



}
