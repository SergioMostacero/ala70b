package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   public List<Usuario> getUsuarios() {
      return usuarioRepository.findAll();
   }

   public Usuario getUsuarioById(Long id) {
      return usuarioRepository.findById(id)
         .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
   }

   public Usuario deleteUsuarioById(Long id) {
      Usuario usuario = getUsuarioById(id);
      usuarioRepository.deleteById(id);
      return usuario;
   }

   public Usuario createUsuario(Usuario usuario) {
      return usuarioRepository.save(usuario);
   }

   public Usuario updateUsuarioName(Long id, String newName) {
      Usuario usuario = getUsuarioById(id);
      usuario.setNombre(newName);
      return usuarioRepository.save(usuario);
   }
}
   