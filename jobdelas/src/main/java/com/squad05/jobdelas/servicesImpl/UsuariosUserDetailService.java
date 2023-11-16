// package com.squad05.jobdelas.servicesImpl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.squad05.jobdelas.controller.UsuariosDetailImpl;
// import com.squad05.jobdelas.model.Usuarios;
// import com.squad05.jobdelas.services.UsuariosService;

// @Service
// public class UsuariosUserDetailService implements UserDetailsService {

// @Autowired
// private UsuariosService usuariosService;

// @Override
// public UserDetails loadUserByUsername(String email) throws
// UsernameNotFoundException {
// Usuarios usuarios = usuariosService.buscarUsuarioPorEmail(email)
// .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado na
// base de dados"));

// return new UsuariosDetailImpl(usuarios);
// }

// }