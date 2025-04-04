package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.model.Avion;

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

    private Integer duracion;

    @NotBlank(message = "Modelo de avión obligatorio")
    private String modelo;

    @NotBlank(message = "Hora de salida obligatoria")
    private String horaSalida;

    @NotBlank(message = "Hora de llegada obligatoria")
    private String horaLlegada;

    @NotBlank(message = "Horas mes obligatorias")
    private String horasMes;

    @NotBlank(message = "Horas año obligatorias")
    private String horasAnio;

    @NotBlank(message = "Horas totales obligatorias")
    private String horasTotales;

    @NotBlank(message = "Anticipo obligatorio")
    private String anticipo;

    @NotBlank(message = "Líquido obligatorio")
    private String liquido;

    @NotBlank(message = "Gasolina obligatoria")
    private String gasolina;


    private Long usuarioId;     
    private Long destinoId;      
    private Long mercanciaId;    
    private Long avionId;     
    private Long misionId;      

    private String usuarioNombre;
    private String destinoNombre;
    private String mercanciaNombre;
    private String avionNombre;
    private String misionNombre;
}
