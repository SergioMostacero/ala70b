package com.example.demo.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private String apellidos;
    
    @Column
    private String email;

    @Column
    private String contrasena;

    @Column
    private Date antiguedad;

    @Column
    private Boolean Permisos;

    @Column
    private String horas_totales;

    @ManyToOne
    @JoinColumn(name = "grupo_sanguineo_id", nullable = false)
    private GrupoSanguineo grupoSanguineo;

    @ManyToOne
    @JoinColumn(name = "rango_id", nullable = false)
    private Rango rango;

    @ManyToOne
    @JoinColumn(name = "oficio_id", nullable = false)
    private Oficio oficio;
    
    @ManyToMany
    @JoinTable(name = "medallas_tripulantes", joinColumns = @JoinColumn(name = "tripulante_id"), inverseJoinColumns = @JoinColumn(name = "medalla_id"))
    List<Medalla> medallas = new ArrayList<>(); // Inicializa vacía

    @ManyToMany
    @JoinTable(name = "vuelos_tripulantes", joinColumns = @JoinColumn(name = "tripulante_id"), inverseJoinColumns = @JoinColumn(name = "vuelo_id"))
    List<Vuelo> vuelos = new ArrayList<>(); // Inicializa vacía;

    

}