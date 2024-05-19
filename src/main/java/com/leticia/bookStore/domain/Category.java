package com.leticia.bookStore.domain;

import com.leticia.bookStore.service.CategoryService;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Getter
@Setter
@Entity
public class Category extends CategoryService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;


    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<> ();

    public Category(Object o, String information, String bookTi) {
    }
}





