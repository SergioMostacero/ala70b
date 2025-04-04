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


    @NotBlank(message = "Hora de salida obligatoria")
    private String hora_salida;

    @NotBlank(message = "Hora de llegada obligatorio")
    private String hora_llegada;

    @NotBlank(message = "anticipo obligatorio")
    private String anticipo;

    @NotBlank(message = "Gasolina obligatorio")
    private String gasolina;


    @ManyToOne
    @JoinColumn(name = "avion_id")
    @JsonManagedReference
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "mision_id")
    @JsonManagedReference
    private Mision misiones;

    @ManyToOne
    @JoinColumn(name = "itinerario_id")
    @JsonManagedReference
    private Itinerario itinerario;

}
