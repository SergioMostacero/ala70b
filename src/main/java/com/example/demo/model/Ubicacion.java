package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String paisCodigo;

    @Column
    private String pais;

    @Column
    private String ciudad;

    @Column
    private String zonaHoraria;

    @Column
    private String latitud;

    @Column
    private String longitud;

    @OneToMany(mappedBy = "ubicacion")
    @JsonIgnore
    private List<ItinerarioUbicacion> itinerarioUbicaciones;

    
}
