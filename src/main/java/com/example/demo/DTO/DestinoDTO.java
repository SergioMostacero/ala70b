package com.example.demo.DTO;

import com.example.demo.validation.CorrectNumber;
import com.example.demo.validation.EmailConstraint;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Data;

@Data
public class DestinoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String imagenURL;

    @NotBlank(message = "Imagen de bandera obligatoria")
    private String banderaURL;

    UsuarioDTO usuarioDTO;
}
