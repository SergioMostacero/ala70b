package com.example.demo.controller;

import com.example.demo.DTO.RangoDTO;
import com.example.demo.services.RangoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/rangos")
@CrossOrigin(origins = "*")
public class RangoController {

    @Autowired
    private RangoService rangoService;

    @GetMapping
    public ResponseEntity<List<RangoDTO>> getAll() {
        List<RangoDTO> dtos = rangoService.getAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RangoDTO> getById(@PathVariable Long id) {
        RangoDTO dto = rangoService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RangoDTO> create(@RequestBody RangoDTO dto) {
        RangoDTO created = rangoService.create(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RangoDTO> update(
            @PathVariable Long id,
            @RequestBody RangoDTO dto
    ) {
        dto.setId(id);
        RangoDTO updated = rangoService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rangoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
