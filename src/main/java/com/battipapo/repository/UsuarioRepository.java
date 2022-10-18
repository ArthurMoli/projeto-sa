package com.battipapo.repository;


import com.battipapo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {

    static Usuario findByUsername(String username) {
        return findByUsername(username);
    }

    public Usuario findById(long id);

}
