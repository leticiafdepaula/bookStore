package com.leticia.bookStore.service;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.repository.BookRepository;
import com.leticia.bookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookRepository bookRepository;

    public void instanciaBaseDeDados() {

            Category cat1 = new Category (null, "information", "book TI");
            Category cat2 = new Category (null, "System Information", "book TI");
            Category cat3 = new Category (null, "Cloud Computing", "book Cloud");

            Book book1 = new Book (null, "Clean Code", "Robertin Martin","Lorem Ipsum", cat1);
            Book book2 = new Book (null, "System Information", "Kelly Rainer Jr","Cegielski", cat2);
            Book book3 = new Book (null, "Cloud Computing", " Curtis Franklin Júnior","Brian J. S. Chee", cat3);
            Book book4 = new Book (null, "Clean Code", " Zaigham Mahmood","Thomas Erl, Ricardo Puttini", cat3);

            cat1.getBooks ().addAll (Arrays.asList (book1, book2));
            cat2.getBooks () .addAll (Arrays.asList (book3, book4));

            this.categoryRepository.saveAll (Arrays.asList (cat1, cat2, cat3));
            this.bookRepository.saveAll (Arrays.asList (book1, book2, book3, book4));
        }
    }


