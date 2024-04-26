package com.leticia.bookStore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Book {
    private Integer id;
    private String titulo;
    private String nome_autor;
    private String texto;
    private Category category;
}
