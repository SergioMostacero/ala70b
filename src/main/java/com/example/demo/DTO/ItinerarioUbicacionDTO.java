package com.example.demo.DTO;

import com.example.demo.model.Itinerario;
import com.example.demo.model.Ubicacion;

import lombok.Data;

@Data
public class ItinerarioUbicacionDTO {

    private Long id;

    private ItinerarioDTO itinerarioDTO;

    private UbicacionDTO ubicacionDTO;

    private Integer orden;

}
