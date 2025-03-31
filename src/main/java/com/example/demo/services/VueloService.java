package com.example.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.VueloDTO;
import com.example.demo.model.Avion;
import com.example.demo.model.Localizacion;
import com.example.demo.model.Mercancia;
import com.example.demo.model.Mision;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vuelo;
import com.example.demo.repository.AvionRepository;
import com.example.demo.repository.LocalizacionRepository;
import com.example.demo.repository.MercanciaRepository;
import com.example.demo.repository.MisionRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VueloRepository;

@Service
public class VueloService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LocalizacionRepository localizacionRepository;

    @Autowired
    private MercanciaRepository mercanciaRepository;

    @Autowired
    private AvionRepository avionRepository;

    @Autowired
    private MisionRepository misionRepository;

    public List<VueloDTO> getAllVuelos() {
        return vueloRepository.findAll()
            .stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    public VueloDTO getVueloById(Long id) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
        return convertToDTO(vuelo);
    }

    public VueloDTO createVuelo(VueloDTO dto) {
        Vuelo vuelo = convertToEntity(dto);
        vuelo = vueloRepository.save(vuelo);
        return convertToDTO(vuelo);
    }

    public VueloDTO updateVuelo(Long id, VueloDTO dto) {
        Vuelo vuelo = vueloRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        vuelo.setFecha(dto.getFecha());
        vuelo.setDuracion(dto.getDuracion());
        vuelo.setModelo(dto.getModelo());
        vuelo.setHora_salida(dto.getHoraSalida());
        vuelo.setHora_llegada(dto.getHoraLlegada());
        vuelo.setHoras_mes(dto.getHorasMes());
        vuelo.setHoras_año(dto.getHorasAnio());
        vuelo.setHoras_totales(dto.getHorasTotales());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setLiquido(dto.getLiquido());
        vuelo.setGasolina(dto.getGasolina());
        vuelo.setHotel(dto.getHotel());

        if (dto.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            vuelo.setUsuarios(usuario);
        }
        if (dto.getDestinoId() != null) {
            Localizacion destino = localizacionRepository.findById(dto.getDestinoId())
                .orElseThrow(() -> new RuntimeException("Localización no encontrada"));
            vuelo.setLocalizaciones(destino);
        }
        if (dto.getMercanciaId() != null) {
            Mercancia mercancia = mercanciaRepository.findById(dto.getMercanciaId())
                .orElseThrow(() -> new RuntimeException("Mercancía no encontrada"));
            vuelo.setMercancias(mercancia);
        }
        if (dto.getAvionId() != null) {
            Avion avion = avionRepository.findById(dto.getAvionId())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
            vuelo.setAviones(avion);
        }
        if (dto.getMisionId() != null) {
            Mision mision = misionRepository.findById(dto.getMisionId())
                .orElseThrow(() -> new RuntimeException("Misión no encontrada"));
            vuelo.setMisiones(mision);
        }

        vuelo = vueloRepository.save(vuelo);
        return convertToDTO(vuelo);
    }

    public void deleteVuelo(Long id) {
        if (!vueloRepository.existsById(id)) {
            throw new RuntimeException("Vuelo no encontrado");
        }
        vueloRepository.deleteById(id);
    }

    private VueloDTO convertToDTO(Vuelo vuelo) {
        VueloDTO dto = new VueloDTO();
        dto.setId(vuelo.getId());
        dto.setFecha(vuelo.getFecha());
        dto.setDuracion(vuelo.getDuracion());
        dto.setModelo(vuelo.getModelo());
        dto.setHoraSalida(vuelo.getHora_salida());
        dto.setHoraLlegada(vuelo.getHora_llegada());
        dto.setHorasMes(vuelo.getHoras_mes());
        dto.setHorasAnio(vuelo.getHoras_año());
        dto.setHorasTotales(vuelo.getHoras_totales());
        dto.setAnticipo(vuelo.getAnticipo());
        dto.setLiquido(vuelo.getLiquido());
        dto.setGasolina(vuelo.getGasolina());
        dto.setHotel(vuelo.getHotel());

        if (vuelo.getUsuarios() != null) {
            dto.setUsuarioId(vuelo.getUsuarios().getId());
            dto.setUsuarioNombre(vuelo.getUsuarios().getNombre()); // or getNombreCompleto
        }

        if (vuelo.getLocalizaciones() != null) {
            dto.setDestinoId(vuelo.getLocalizaciones().getId());
            dto.setDestinoNombre(vuelo.getLocalizaciones().getNombre());
        }

        if (vuelo.getMercancias() != null) {
            dto.setMercanciaId(vuelo.getMercancias().getId());
            dto.setMercanciaNombre(vuelo.getMercancias().getNombre()); 
        }

        if (vuelo.getAviones() != null) {
            dto.setAvionId(vuelo.getAviones().getId());
            dto.setAvionNombre(vuelo.getAviones().getNombre());
        }

        if (vuelo.getMisiones() != null) {
            dto.setMisionId(vuelo.getMisiones().getId());
            dto.setMisionNombre(vuelo.getMisiones().getNombre()); 
        }

        return dto;
    }

    private Vuelo convertToEntity(VueloDTO dto) {
        Vuelo vuelo = new Vuelo();

        vuelo.setFecha(dto.getFecha());
        vuelo.setDuracion(dto.getDuracion());
        vuelo.setModelo(dto.getModelo());
        vuelo.setHora_salida(dto.getHoraSalida());
        vuelo.setHora_llegada(dto.getHoraLlegada());
        vuelo.setHoras_mes(dto.getHorasMes());
        vuelo.setHoras_año(dto.getHorasAnio());
        vuelo.setHoras_totales(dto.getHorasTotales());
        vuelo.setAnticipo(dto.getAnticipo());
        vuelo.setLiquido(dto.getLiquido());
        vuelo.setGasolina(dto.getGasolina());
        vuelo.setHotel(dto.getHotel());

        if (dto.getUsuarioId() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            vuelo.setUsuarios(usuario);
        }
        if (dto.getDestinoId() != null) {
            Localizacion destino = localizacionRepository.findById(dto.getDestinoId())
                .orElseThrow(() -> new RuntimeException("Localizacion no encontrada"));
            vuelo.setLocalizaciones(destino);
        }
        if (dto.getMercanciaId() != null) {
            Mercancia mercancia = mercanciaRepository.findById(dto.getMercanciaId())
                .orElseThrow(() -> new RuntimeException("Mercancía no encontrada"));
            vuelo.setMercancias(mercancia);
        }
        if (dto.getAvionId() != null) {
            Avion avion = avionRepository.findById(dto.getAvionId())
                .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
            vuelo.setAviones(avion);
        }
        if (dto.getMisionId() != null) {
            Mision mision = misionRepository.findById(dto.getMisionId())
                .orElseThrow(() -> new RuntimeException("Misión no encontrada"));
            vuelo.setMisiones(mision);
        }

        return vuelo;
    }
}
