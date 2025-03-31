package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Integer duracion;

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

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Vuelo localizacion;
}
