package com.leticia.bookStore.dtos;

import com.leticia.bookStore.domain.Book;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BookDto implements Serializable {
    private static final long serialVersionUID = 1l;

    private Integer id;
    private String titulo;
    public BookDto() {
        super();
    }

    public BookDto(Book obj) {
        super();
        this.id = obj.getId ();
        this.titulo = obj.getTitulo ();


    }
}
