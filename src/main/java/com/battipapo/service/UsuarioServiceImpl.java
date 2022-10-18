package com.battipapo.service;


import com.battipapo.model.Permission;
import com.battipapo.model.Usuario;
import com.battipapo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    private Object permissionRepository;

    public List <Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id){
        Usuario usu = usuarioRepository.findById(id).get();
        return usu != null ? usu : new Usuario();
    }

    @Override
    public Usuario save(Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userAux = UsuarioRepository.findByUsername(username);
        if (userAux == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(userAux.getUsername())
                .password(userAux.getSenha())
                .authorities(authorities(userAux)).build();
        return user;
    }

public Collection<GrantedAuthority> authorities(Usuario user){
        
        Collection<GrantedAuthority> autoriza = new ArrayDeque<>();
        List<Permission> permissions = permissionRepository.findByUsersIn(user);
        for (Permission permission: permissions){
            autoriza.add(new SimpleGrantedAuthority("ROLE" + permission.getNome()));
        }
        return autoriza;
}


}

