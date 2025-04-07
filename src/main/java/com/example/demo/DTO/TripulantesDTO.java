package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Vuelo;

import lombok.Data;


@Data
public class TripulantesDTO {
    
    private Long id;

    private String nombre;

    private String email;

    private String contrasena;

    private int antiguedad;

    private String horas_mes;

    private String horas_año;

    private String horas_totales;

    private GrupoSanguineoDTO grupoSanguineoDTO;

    List<MedallaDTO> medallasDTO;

    private RangoDTO rangoDTO;

    private OficioDTO oficioDTO;

    List<Vuelo> vuelos;


}
