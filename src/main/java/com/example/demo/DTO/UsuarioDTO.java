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
public class UsuarioDTO {
    
    @NotBlank(message = "Nombre de usuario obligatorio")
    private String nombre;

    @NotBlank(message = "Apellido de usuario obligatorio")
    private String apellido;

    @NotBlank(message = "Apellido2 de usuario obligatorio")
    private String apellido2;

    @NotBlank(message = "Grupo sanguineo obligatorio")
    private String grupo_sanguineo;

    @NotBlank(message = "Antigüedad de usuario obligatorio")
    private String antiguedad;

    @NotBlank(message = "Horas de vuelo obligatorio")
    private String horas_vuelo;

    @NotBlank(message = "User mail is mandatory")
    @EmailConstraint(message = "Invalid email format. Must be in the format example@domain.com")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @CorrectNumber(message = "phone number out of format")
    private String phoneNumber;

    VueloDTO vueloDTO;
    RangoDTO rangoDTO;
    DestinoDTO destinoDTO;

}
