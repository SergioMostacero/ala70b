package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

import com.example.demo.DTO.VueloDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;

@Data
@Entity
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Integer duracion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

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

    // In Vuelo.java
    @ManyToMany(mappedBy = "vuelos", cascade = CascadeType.ALL) 
    private List<Usuario> usuarios = new ArrayList<>();

}
