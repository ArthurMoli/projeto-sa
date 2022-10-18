package com.battipapo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "username")
    @Size(max = 16)
    @NotNull
    private String username;

    @Column(name = "nome")
    @Size(max = 40)
    @NotNull
    private String nome;

    @Column(name = "sobrenome")
    @Size(max = 60)
    @NotNull
    private String sobrenome;

    @Column(name = "idade")
    @NotNull
    private Integer idade;

    @Column(name = "email")
    @NotNull
    @Size(max = 40)
    private String email;

    @Column(name = "senha")
    @NotNull
    private String senha;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
