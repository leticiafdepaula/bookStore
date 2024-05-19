package com.leticia.bookStore.service;

import com.leticia.bookStore.domain.Book;
import com.leticia.bookStore.exception.ObjectNotFoundException;
import com.leticia.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id) {
        Optional<Book> obj = bookRepository.findById (id);
        return obj.orElseThrow (() -> new ObjectNotFoundException (
                "objeto não encontrado! id: "+ id + ", Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_cat) {
        categoryService.findById (id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book update(Integer id, Book obj) {
     Book newObj = findById (id);
     updateData (newObj, obj);
     return bookRepository.save (newObj);
    }

    private void updateData(Book newObj, Book obj) {
        newObj.setTitulo(obj.getTexto ());
        newObj.setNome(obj.getNome_autor ());
        newObj.setTexto(obj.getTexto ());


    }
}
