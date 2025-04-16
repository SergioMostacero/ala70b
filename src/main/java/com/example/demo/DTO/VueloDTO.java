package com.example.demo.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

/**
 * A DTO representing the Vuelo entity, including references by ID
 * to Avion, Mision and Itinerario.
 */
@Data
public class VueloDTO {
    private Long id;

    private LocalDate fecha;
    private LocalTime hora_salida;
    private LocalTime hora_llegada;
    private String anticipo;
    private String gasolina;

    private AvionDTO avionDTO;
    private MisionDTO misionesDTO;
    private ItinerarioDTO itinerarioDTO;
}
