package com.example.demo.DTO;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class AvionDTO {

    private Long id;

    private String nombre;

    private BigDecimal max_combustible;

    private List<VueloDTO> vueloDTOs;
}
