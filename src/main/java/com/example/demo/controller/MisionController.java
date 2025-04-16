package com.example.demo.controller;

import com.example.demo.model.Mision;
import com.example.demo.services.MisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/misiones")
@CrossOrigin(origins = "*")
public class MisionController {

    @Autowired
    private MisionService misionService;

    @GetMapping
    public ResponseEntity<List<Mision>> getAllMisiones() {
        return ResponseEntity.ok(misionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mision> getMisionById(@PathVariable Long id) {
        return ResponseEntity.ok(misionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Mision> createMision(@RequestBody Mision mision) {
        return ResponseEntity.ok(misionService.create(mision));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mision> updateMision(@PathVariable Long id, @RequestBody Mision mision) {
        mision.setId(id);
        return ResponseEntity.ok(misionService.update(mision));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMision(@PathVariable Long id) {
        misionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
