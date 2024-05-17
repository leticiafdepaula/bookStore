package com.leticia.bookStore.service;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.exception.ObjectNotFoundException;
import com.leticia.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book findById(Integer id) {
        Optional<Book> obj = bookRepository.findById (id);
        return obj.orElseThrow (() -> new ObjectNotFoundException (
                "objeto não encontrado! id: "+ id + ", Tipo: " + Book.class.getName()));
    }
}
