package com.leticia.bookStore.resource;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/livros")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping( "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
     Book obj = service.findById (id);
     return ResponseEntity.ok ().body (obj);
    }

}
