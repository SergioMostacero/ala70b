package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.ItinerarioUbicacion;

import lombok.Data;

@Data
public class UbicacionDTO {
    private int id;

    private String paisCodigo;

    private String pais;

    private String ciudad;

    private String zonaHoraria;

    private String latitud;

    private String longitud;

    private List<ItinerarioUbicacionDTO> ItinerarioUbicacionesDTO;

}
