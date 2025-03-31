package com.example.demo.model;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.validation.CorrectNumber;
import com.example.demo.validation.EmailConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nombre de usuario obligatorio")
    private String nombre;

    @NotBlank(message = "Apellido de usuario obligatorio")
    private String apellidos;

    @NotBlank(message = "El email de usuario es obligatorio")
    @EmailConstraint(message = "Email en formato incorrecto, debe ser example@domain.com")
    private String email;

    @NotBlank(message = "Grupo sanguineo obligatorio")
    private String grupo_sanguineo;

    @NotBlank(message = "Antigüedad de usuario obligatorio")
    private String antiguedad;

    @NotBlank(message = "Horas de vuelo obligatorio")
    private String horas_vuelo;

    @NotBlank(message = "La contraseña es obligatoria")
    private String contrasena;

    @NotBlank(message = "El número de teléfono es obligatorio")
    @CorrectNumber(message = "Número de teléfono fuera de formato")
    private String numeroTelefono;


    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vuelo> vuelos = new ArrayList<>();

    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tripulantes> tripulantes = new ArrayList<>();

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "medalla_id")
    private Medalla medallas;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "rango_id")
    private Rango rangos;

}
