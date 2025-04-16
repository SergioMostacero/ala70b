package com.example.demo.controller;

import com.example.demo.model.Ubicacion;
import com.example.demo.services.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@CrossOrigin(origins = "*")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @GetMapping
    public ResponseEntity<List<Ubicacion>> getAllUbicaciones() {
        return ResponseEntity.ok(ubicacionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> getUbicacionById(@PathVariable int id) {
        return ResponseEntity.ok(ubicacionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Ubicacion> createUbicacion(@RequestBody Ubicacion ubicacion) {
        return ResponseEntity.ok(ubicacionService.create(ubicacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubicacion> updateUbicacion(@PathVariable int id, @RequestBody Ubicacion ubicacion) {
        ubicacion.setId(id);
        return ResponseEntity.ok(ubicacionService.update(ubicacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbicacion(@PathVariable int id) {
        ubicacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
