package com.example.demo.DTO;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * A DTO representing the Vuelo entity, including references by ID
 * to Avion, Mision and Itinerario.
 */
@Data
public class VueloDTO {
    private Long id;

    private LocalDateTime fecha;
    private String hora_salida;
    private String hora_llegada;
    private String anticipo;
    private String gasolina;

    private AvionDTO avionDTO;
    private MisionDTO misionesDTO;
    private ItinerarioDTO itinerarioDTO;
}
