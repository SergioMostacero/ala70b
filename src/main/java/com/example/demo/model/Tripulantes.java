package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tripulantes")
public class Tripulantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String email;

    @Column
    private String contrasena;

    @Column
    private String antiguedad;

    @Column
    private String horas_vuelo;

    @ManyToOne
    @JoinColumn(name = "grupo_sanguineo_id", nullable = false)
    private GrupoSanguineo grupoSanguineo;

    @ManyToMany
    @JoinTable(name = "medallas_tripulantes", joinColumns = @JoinColumn(name = "tripulante_id"), inverseJoinColumns = @JoinColumn(name = "medalla_id"))
    List<Medalla> medallas;

    @ManyToOne
    @JoinColumn(name = "rango_id", nullable = false)
    private Rango rango;

    @ManyToOne
    @JoinColumn(name = "oficio_id", nullable = false)
    private Oficio oficio;
    

    @ManyToMany
    @JoinTable(name = "vuelos_tripulantes", joinColumns = @JoinColumn(name = "tripulante_id"), inverseJoinColumns = @JoinColumn(name = "vuelo_id"))
    List<Vuelo> vuelos;

    

}