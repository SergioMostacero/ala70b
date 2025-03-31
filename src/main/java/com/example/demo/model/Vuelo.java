package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @NotBlank(message = "Modelo de avión de usuario obligatorio")
    private String modelo;

    @NotBlank(message = "Hora de salida obligatoria")
    private String hora_salida;

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
    @JoinColumn(name = "usuarios", nullable = false)
    private Usuario usuarios;

    @ManyToOne
    @JoinColumn(name = "localizaciones", nullable = false)
    private Localizacion localizaciones;

    @OneToMany(mappedBy = "vuelos", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Escalas> escalas = new ArrayList<>();

    @OneToMany(mappedBy = "vuelos", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Tripulantes> tripulantes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "mercancia_id")
    @JsonManagedReference
    private Mercancia mercancias;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonManagedReference
    private Avion aviones;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    @JsonManagedReference
    private Mision misiones;


}
