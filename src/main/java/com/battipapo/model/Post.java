package com.battipapo.model;

import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "texto")
    @NotNull
    private String texto;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id=" + Id +
                ", texto='" + texto + '\'' +
                '}';
    }
}
