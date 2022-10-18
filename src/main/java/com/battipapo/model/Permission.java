package com.battipapo.model;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 60)
    private String nome;

    @ManyToMany(mappedBy = "permissions")
    private List<Usuario> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", users=" + users +
                '}';
    }
}
