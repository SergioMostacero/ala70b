package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.ItinerarioUbicacion;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data   
public class ItinerarioDTO {
    
    private Long id;
    
    private String nombre;

    private List<ItinerarioUbicacionDTO> ItinerarioUbicacionDTO;
}
