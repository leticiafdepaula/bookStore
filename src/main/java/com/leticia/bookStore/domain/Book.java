package com.leticia.bookStore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Value
@EqualsAndHashCode
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

    public void setTitulo(String texto) {
    }

    public void setNome(String nomeAutor) {
    }

    public void setTexto(String texto) {
    }
}
