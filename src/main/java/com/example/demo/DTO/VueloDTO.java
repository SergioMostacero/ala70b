package com.example.demo.DTO;

import com.example.demo.validation.CorrectNumber;
import com.example.demo.validation.EmailConstraint;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VueloDTO {
    @NotBlank(message = "Fecha de vuelo obligatorio")
    private String fecha;

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
