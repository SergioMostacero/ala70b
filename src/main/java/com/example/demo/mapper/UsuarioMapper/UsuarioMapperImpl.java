package com.example.demo.mapper.UsuarioMapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.model.Usuario;

@Component
public class UsuarioMapperImpl implements UsuarioMapper{
    
    @Override
    public UsuarioDTO toDTO(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNombre(usuario.getNombre());

        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> toListDTO(List<Usuario>usuarios){
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuarioDTOs.add(toDTO(usuario));
        }
        return usuarioDTOs;
    }


}
