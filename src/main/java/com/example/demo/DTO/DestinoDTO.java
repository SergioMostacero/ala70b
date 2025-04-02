package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DestinoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagenURL;

    @NotBlank(message = "Imagen de bandera obligatoria")
    private String banderaURL;

    TripulantesDTO TripulantesDTO;
}
