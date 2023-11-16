package com.squad05.jobdelas.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.squad05.jobdelas.model.Usuarios;

public class UsuariosDetailImpl implements UserDetails {

    private Usuarios usuarios;

    public UsuariosDetailImpl(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }

    @Override
    public String getPassword() {
        return usuarios.getSenha();
    }

    @Override
    public String getUsername() {
        return usuarios.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
