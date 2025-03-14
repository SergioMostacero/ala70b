package com.example.demo.mapper.UsuarioMapper;

import java.util.List;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.model.Usuario;

public interface UsuarioMapper {

    List<UsuarioDTO> toListDTO(List<Usuario>usuarios);

    UsuarioDTO toDTO(Usuario usuario);
}
