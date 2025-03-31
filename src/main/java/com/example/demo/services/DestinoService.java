package com.example.demo.services;

import com.example.demo.DTO.DestinoDTO;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Localizacion;
import com.example.demo.repository.DestinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<DestinoDTO> getAllDestinos() {
        return destinoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DestinoDTO getDestinoById(Long id) {
        return destinoRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Destino no encontrado con id: " + id));
    }

    public DestinoDTO createDestino(DestinoDTO destinoDTO) {
        Localizacion destino = convertToEntity(destinoDTO);
        return convertToDTO(destinoRepository.save(destino));
    }

    public DestinoDTO updateDestino(Long id, DestinoDTO destinoDTO) {
        if (destinoDTO == null) {
            throw new IllegalArgumentException("El DTO del destino no puede ser nulo");
        }
        
        Localizacion destino = destinoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destino no encontrado con id: " + id));
        
        updateDestinoFields(destino, destinoDTO);
        return convertToDTO(destinoRepository.save(destino));
    }

    private void updateDestinoFields(Localizacion destino, DestinoDTO dto) {
        destino.setNombre(dto.getNombre());
        destino.setDescripcion(dto.getDescripcion());
        destino.setImagenURL(dto.getImagenURL());
    }

    public void deleteDestino(Long id) {
        destinoRepository.deleteById(id);
    }

    private DestinoDTO convertToDTO(Localizacion destino) {
        DestinoDTO dto = new DestinoDTO();
        dto.setId(destino.getId());
        dto.setNombre(destino.getNombre());
        dto.setDescripcion(destino.getDescripcion());
        dto.setImagenURL(destino.getImagenURL());
        return dto;
    }

    private Localizacion convertToEntity(DestinoDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El DTO no puede ser nulo");
        }
        
        Localizacion destino = new Localizacion();
        destino.setId(dto.getId());
        destino.setNombre(dto.getNombre());
        destino.setDescripcion(dto.getDescripcion());
        destino.setImagenURL(dto.getImagenURL());
        return destino;
    }
}