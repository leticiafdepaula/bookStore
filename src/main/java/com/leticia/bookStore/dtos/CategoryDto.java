package com.leticia.bookStore.dtos;

import com.leticia.bookStore.domain.Category;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class CategoryDto implements Serializable {

    private static final long serialversionUID = 1l;

    private Integer id;
    private String nome;
    private String descricao;

    public CategoryDto(Category obj) {
        this.id = obj.getId ();
        this.nome = obj.getNome ();
        this.descricao = obj.getDescricao ();
    }
}
