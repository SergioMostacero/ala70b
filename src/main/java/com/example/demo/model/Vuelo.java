package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vuelos")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private LocalTime hora_salida;

    @Column(nullable = false)
    private LocalTime hora_llegada;

    @Column(nullable = false)
    private String anticipo;

    @Column(nullable = false)
    private String gasolina;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonManagedReference
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    @JsonManagedReference
    private Mision misiones;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    @JsonManagedReference
    private Itinerario itinerario;

    @ManyToMany(mappedBy = "vuelos")
    @JsonBackReference
    private List<Tripulantes> tripulantes = new ArrayList<>();
}
