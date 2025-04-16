package com.example.demo.controller;

import com.example.demo.model.Itinerario;
import com.example.demo.services.ItinerarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itinerarios")
@CrossOrigin(origins = "*")
public class ItinerarioController {

    @Autowired
    private ItinerarioService itinerarioService;

    @GetMapping
    public ResponseEntity<List<Itinerario>> getAllItinerarios() {
        return ResponseEntity.ok(itinerarioService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerario> getItinerarioById(@PathVariable Long id) {
        return ResponseEntity.ok(itinerarioService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Itinerario> createItinerario(@RequestBody Itinerario itinerario) {
        return ResponseEntity.ok(itinerarioService.create(itinerario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itinerario> updateItinerario(@PathVariable Long id, @RequestBody Itinerario itinerario) {
        itinerario.setId(id);
        return ResponseEntity.ok(itinerarioService.update(itinerario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerario(@PathVariable Long id) {
        itinerarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
