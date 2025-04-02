package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "itinerario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Itinerario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    @JoinTable(name = "itinerario_ubicacion", joinColumns = @JoinColumn(name = "itinerario_id"), inverseJoinColumns = @JoinColumn(name = "ubicacion_id"))
    List<Ubicacion> ubicaciones;
}
