package com.example.demo.mapper.VueloMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.AvionDTO;
import com.example.demo.DTO.ItinerarioDTO;
import com.example.demo.DTO.MisionDTO;
import com.example.demo.DTO.VueloDTO;
import com.example.demo.mapper.AvionMapper.AvionMapper;
import com.example.demo.mapper.ItinerarioMapper.ItinerarioMapper;
import com.example.demo.mapper.MisionMapper.MisionMapper;
import com.example.demo.model.Avion;
import com.example.demo.model.Itinerario;
import com.example.demo.model.Mision;
import com.example.demo.model.Vuelo;

@Component
public class VueloMapperImpl implements VueloMapper {

    @Autowired
    private AvionMapper avionMapper; 
    @Autowired
    private MisionMapper misionMapper; 
    @Autowired
    private ItinerarioMapper itinerarioMapper;

    @Override
    public VueloDTO toDTO(Vuelo vuelo) {
        if (vuelo == null) {
            return null;
        }
    
        VueloDTO dto = new VueloDTO();
    
        dto.setId(vuelo.getId());
        dto.setFecha_salida(vuelo.getFecha_salida());
        dto.setHora_salida(vuelo.getHora_salida());
        dto.setHora_llegada(vuelo.getHora_llegada());
        dto.setFecha_llegada(vuelo.getFecha_llegada());
        dto.setAnticipo(vuelo.getAnticipo());
        dto.setGasolina(vuelo.getGasolina());
    
        // Avion
        if (vuelo.getAvion() != null) {
            dto.setAvionDTO(avionMapper.toDTO(vuelo.getAvion()));
        }
    
        // Mision
        if (vuelo.getMisiones() != null) {
            dto.setMisionDTO(misionMapper.toDTO(vuelo.getMisiones()));
        }
    
        // Itinerario
        if (vuelo.getItinerario() != null) {
            dto.setItinerarioDTO(itinerarioMapper.toDTO(vuelo.getItinerario()));
        }
    
        return dto;
    }
    

    @Override
    public Vuelo toEntity(VueloDTO dto) {
        if (dto == null) {
            return null;
        }

        Vuelo vuelo = new Vuelo();
        // Campos directos
        vuelo.setId(dto.getId()); // Ojo con setId si es create
        vuelo.setFecha_salida(dto.getFecha_salida());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setFecha_llegada(dto.getFecha_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setGasolina(dto.getGasolina());

        // Avion: convertimos AvionDTO -> Avion (solo si no es null)
        if (dto.getAvionDTO() != null) {
            Avion avion = new Avion();
            avion.setId(dto.getAvionDTO().getId());
            vuelo.setAvion(avion);
        }
        
        // Repetir para misionDTO e itinerarioDTO
        if (dto.getMisionDTO() != null) {
            Mision mision = new Mision();
            mision.setId(dto.getMisionDTO().getId());
            vuelo.setMisiones(mision);
        }
        
        if (dto.getItinerarioDTO() != null) {
            Itinerario itinerario = new Itinerario();
            itinerario.setId(dto.getItinerarioDTO().getId());
            vuelo.setItinerario(itinerario);
        }
        
        return vuelo;
    }

    @Override
    public List<VueloDTO> toListDTO(List<Vuelo> vuelos) {
        List<VueloDTO> result = new ArrayList<>();
        if (vuelos != null) {
            for (Vuelo v : vuelos) {
                result.add(toDTO(v));
            }
        }
        return result;
    }
}
