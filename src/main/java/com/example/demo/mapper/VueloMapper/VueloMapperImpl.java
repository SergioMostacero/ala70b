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
        // Campos directos
        dto.setId(vuelo.getId());
        dto.setFecha(vuelo.getFecha());
        dto.setHora_salida(vuelo.getHora_salida());
        dto.setHora_llegada(vuelo.getHora_llegada());
        dto.setAnticipo(vuelo.getAnticipo());
        dto.setGasolina(vuelo.getGasolina());

        // Avion
        if (vuelo.getAvion() != null) {
            AvionDTO avionDTO = avionMapper.toDTO(vuelo.getAvion());
            dto.setAvionDTO(avionDTO);
        }

        // Mision
        if (vuelo.getMisiones() != null) {
            MisionDTO misionDTO = misionMapper.toDTO(vuelo.getMisiones());
            dto.setMisionesDTO(misionDTO);
        }

        // Itinerario
        if (vuelo.getItinerario() != null) {
            ItinerarioDTO itinerarioDTO = itinerarioMapper.toDTO(vuelo.getItinerario());
            dto.setItinerarioDTO(itinerarioDTO);
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
        vuelo.setFecha(dto.getFecha());
        vuelo.setHora_salida(dto.getHora_salida());
        vuelo.setHora_llegada(dto.getHora_llegada());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setGasolina(dto.getGasolina());

        // Avion: convertimos AvionDTO -> Avion (solo si no es null)
        if (dto.getAvionDTO() != null) {
            Avion avionEntity = avionMapper.toEntity(dto.getAvionDTO());
            vuelo.setAvion(avionEntity);
        }

        // Mision
        if (dto.getMisionesDTO() != null) {
            Mision misionEntity = misionMapper.toEntity(dto.getMisionesDTO());
            vuelo.setMisiones(misionEntity);
        }

        // Itinerario
        if (dto.getItinerarioDTO() != null) {
            Itinerario itinerarioEntity = itinerarioMapper.toEntity(dto.getItinerarioDTO());
            vuelo.setItinerario(itinerarioEntity);
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
