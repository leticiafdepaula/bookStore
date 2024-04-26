package com.leticia.bookStore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
public class Category {
    private Integer id;
    private String nome;
    private String descricao;

    private List<Book> books = new ArrayList<>();

}
