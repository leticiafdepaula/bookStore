package com.leticia.bookStore.resource;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.dtos.BookDto;
import com.leticia.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Nodes.collect;

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

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat) {
     List<Book> List = service.findAll(id_cat);
     List<BookDto> ListDto = List.stream ().map (obj -> new BookDto (obj)).collect (Collectors.toList ());
     return ResponseEntity.ok ().body (ListDto);
    }

}
