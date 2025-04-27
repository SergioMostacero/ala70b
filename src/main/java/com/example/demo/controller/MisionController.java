package com.example.demo.controller;

import com.example.demo.DTO.MisionDTO;
import com.example.demo.services.MisionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/misiones")
@CrossOrigin(origins = "*")
public class MisionController {

    @Autowired
    private MisionService misionService;

    @GetMapping
    public ResponseEntity<List<MisionDTO>> getAllMisiones() {
        List<MisionDTO> dtos = misionService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MisionDTO> getMisionById(@PathVariable Long id) {
        MisionDTO dto = misionService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<MisionDTO> createMision(@RequestBody MisionDTO dto) {
        MisionDTO created = misionService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MisionDTO> updateMision(
            @PathVariable Long id,
            @RequestBody MisionDTO dto
    ) {
        MisionDTO updated = misionService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMision(@PathVariable Long id) {
        misionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
