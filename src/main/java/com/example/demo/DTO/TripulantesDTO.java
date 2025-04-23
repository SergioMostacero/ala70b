package com.example.demo.DTO;

import java.sql.Date;
import java.util.List;

import lombok.Data;


@Data
public class TripulantesDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String contrasena;
    private Date antiguedad; 
    private Boolean permisos;
    private Integer horas_totales;
    
    private GrupoSanguineoDTO grupoSanguineoDTO;
    private List<MedallaDTO> medallasDTO;
    private RangoDTO rangoDTO;
    private OficioDTO oficioDTO;
    private List<VueloDTO> vuelosDTO;


}
