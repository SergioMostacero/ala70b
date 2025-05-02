package com.example.demo.DTO;

import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data   
public class ItinerarioDTO {
    
    private Long id;
    
    private String nombre;

    private LocalTime duracion;

    private List<ItinerarioUbicacionDTO> ItinerarioUbicacionDTO;
}
