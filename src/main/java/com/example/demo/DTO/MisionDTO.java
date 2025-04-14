package com.example.demo.DTO;

import java.util.List;

import lombok.Data;

@Data
public class MisionDTO {
    private Long id;

    private String nombre;

    private List<VueloDTO> vuelosDTO;

}
