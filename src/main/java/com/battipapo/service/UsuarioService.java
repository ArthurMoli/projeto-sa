package com.battipapo.service;


import com.battipapo.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(Long id);

    public Usuario save(Usuario usuario);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
