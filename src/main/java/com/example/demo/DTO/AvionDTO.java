package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Vuelo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class AvionDTO {

    private Long id;

    private String nombre;

    private List<VueloDTO> vueloDTOs;
}
