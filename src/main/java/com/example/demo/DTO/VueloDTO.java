package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.model.Destino;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VueloDTO {
    private Long id;
    private String origen;
    private Destino destino;
    private LocalDateTime fecha;
    private Integer duracion;
    private Long usuarioId;
    private String usuarioNombre;

    @NotBlank(message = "Fecha de vuelo obligatorio")
    private String fecha_vuelo;

    @NotBlank(message = "Mercancia obligatorio")
    private String mercancia;

    @NotBlank(message = "Modelo de avión de usuario obligatorio")
    private String modelo;
    
    @NotBlank(message = "Ubicacion de salida obligatoria")
    private String ubi_salida;

    @NotBlank(message = "Hora de salida obligatoria")
    private String hora_salida;

    @NotBlank(message = "Ubicación de llegada obligatorio")
    private String ubi_llegada;

    @NotBlank(message = "Hora de llegada obligatorio")
    private String hora_llegada;

    @NotBlank(message = "Horas mes obligatorio")
    private String horas_mes;

    @NotBlank(message = "Horas año obligatorio")
    private String horas_año;

    @NotBlank(message = "Horas totales obligatorio")
    private String horas_totales;

    @NotBlank(message = "anticipo obligatorio")
    private String anticipo;

    @NotBlank(message = "Liquido obligatorio")
    private String liquido;

    @NotBlank(message = "Gasolina obligatorio")
    private String gasolina;

    @NotBlank(message = "Hotel obligatorio")
    private String hotel;

    UsuarioDTO usuarioDTO;
}
