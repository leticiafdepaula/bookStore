package com.leticia.bookStore.resource;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.dtos.BookDto;
import com.leticia.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.print.ServiceUI;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentContextPath;

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book obj) {
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok ().body (newObj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updatePath(@PathVariable Integer id, @RequestBody Book obj) {
        Book newObj = service.update(id, obj);
        return ResponseEntity.ok ().body (newObj);
    }
    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "category", defaultValue = "0") Integer id_cat,
      @RequestBody Book obj) {
        Book newObj = service.create (id_cat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path ("/Book/{id}")
        .buildAndExpand (newObj.getId ()).toUri ();
        return ResponseEntity.created (uri).build ();
    }
}
