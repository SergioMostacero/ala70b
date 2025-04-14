package com.example.demo.DTO;

import java.util.List;

import lombok.Data;

@Data   
public class ItinerarioDTO {
    
    private Long id;
    
    private String nombre;

    private String duracion;

    private List<ItinerarioUbicacionDTO> ItinerarioUbicacionDTO;
}
