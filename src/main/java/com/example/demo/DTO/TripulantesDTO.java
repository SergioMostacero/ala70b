package com.example.demo.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;


@Data
public class TripulantesDTO {
    private Long id;
    private String nombre;
    private String apellidos; // ¡Faltaba este campo!
    private String email;
    private String contrasena;
    private LocalDate antiguedad; // Cambiar de int a LocalDate
    private Boolean permisos;
    private String horas_totales;
    
    private GrupoSanguineoDTO grupoSanguineoDTO;
    private List<MedallaDTO> medallasDTO;
    private RangoDTO rangoDTO;
    private OficioDTO oficioDTO;
    private List<VueloDTO> vuelosDTO;


}
