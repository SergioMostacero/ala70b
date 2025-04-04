package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Vuelo;

import lombok.Data;

@Data
public class MisionDTO {
        private Long id;

    private String nombre;

    private List<VueloDTO> vuelosDTO;

}
