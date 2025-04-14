package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medalla;
import com.example.demo.services.MedallaService;

@RestController
@RequestMapping("/api/medallas")
@CrossOrigin(origins = "*")
public class MedallaController {

    @Autowired
    private MedallaService medallaService;

    @GetMapping
    public List<Medalla> getAllMedallas() {
        return medallaService.getAllMedallas();
    }

    @GetMapping("/tripulante/{tripulanteId}")
    public List<Medalla> getMedallasByTripulante(@PathVariable("tripulanteId") Long tripulanteId) {
        return medallaService.getMedallasByTripulante(tripulanteId);
    }

    @PostMapping
    public Medalla createMedalla(@RequestBody Medalla medalla) {
        return medallaService.createMedalla(medalla);
    }
}
