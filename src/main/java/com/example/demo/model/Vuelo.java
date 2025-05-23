package com.example.demo.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vuelos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha_salida;

    @Column(nullable = false)
    private LocalTime hora_salida;

    @Column(nullable = false)
    private LocalTime hora_llegada;

    @Column(nullable = false)
    private LocalDate fecha_llegada;

    @Column(nullable = false)
    private BigDecimal anticipo;

    @Column(nullable = false)
    private BigDecimal combustible;
    
    @Column(nullable = false)
    private boolean horasSumadas = false;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    private Mision misiones;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    private Itinerario itinerario;

    @ManyToMany(mappedBy = "vuelos")
    @JsonIgnore 
    private List<Tripulantes> tripulantes = new ArrayList<>();
}