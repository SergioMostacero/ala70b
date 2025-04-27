package com.example.demo.mapper.UbicacionMapper;

import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.DTO.UbicacionDTO;
import com.example.demo.model.Ubicacion;

@Component
public class UbicacionMapperImpl implements UbicacionMapper {

    @Override
    public UbicacionDTO toDTO(Ubicacion ubicacion) {
        if (ubicacion == null) {
            return null;
        }
        UbicacionDTO dto = new UbicacionDTO();
        dto.setId(ubicacion.getId());
        dto.setPaisCodigo(ubicacion.getPaisCodigo());
        dto.setPais(ubicacion.getPais());
        dto.setCiudad(ubicacion.getCiudad());
        dto.setZonaHoraria(ubicacion.getZonaHoraria());
        dto.setLatitud(ubicacion.getLatitud());
        dto.setLongitud(ubicacion.getLongitud());
        // Mapeo de relaciones se puede manejar en servicios o mappers específicos
        return dto;
    }

    @Override
    public Ubicacion toEntity(UbicacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(dto.getId());
        ubicacion.setPaisCodigo(dto.getPaisCodigo());
        ubicacion.setPais(dto.getPais());
        ubicacion.setCiudad(dto.getCiudad());
        ubicacion.setZonaHoraria(dto.getZonaHoraria());
        ubicacion.setLatitud(dto.getLatitud());
        ubicacion.setLongitud(dto.getLongitud());
        return ubicacion;
    }

    @Override
    public List<UbicacionDTO> toListDTO(List<Ubicacion> ubicaciones) {
        if (ubicaciones == null) {
            return null;
        }
        return ubicaciones.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
