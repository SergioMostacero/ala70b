package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.model.Avion;
import com.example.demo.model.Itinerario;
import com.example.demo.model.Mision;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * A DTO representing the Vuelo entity, including references by ID
 * to Usuario, Destino (Localizacion), Mercancia, Avion, and Mision.
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
