package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

   @Autowired
   private UsuarioRepository usuarioRepository;

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      Usuario usuario = getUsuarioByEmail(email);
      return new User(
         usuario.getEmail(),
         usuario.getPassword(),
         List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRango().getNombre()))
      );
   }

   public Usuario getUsuarioByEmail(String email) {
      return usuarioRepository.findByEmail(email)
         .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + email));
   }

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
   //añadir usuario para añadir con un fich img la foto y el nombre dle pais
   public Usuario createUsuario(Usuario usuario) {
      return usuarioRepository.save(usuario);
   }

   public Usuario updateUsuarioName(Long id, String newName) {
      Usuario usuario = getUsuarioById(id);
      usuario.setNombre(newName);
      return usuarioRepository.save(usuario);
   }

   public Usuario deleteUsuarioAdmin(Long usuarioId, Long roleId) {
      Usuario usuario = getUsuarioById(usuarioId);
      usuarioRepository.deleteById(usuarioId);
      return usuario;
   }
}
   