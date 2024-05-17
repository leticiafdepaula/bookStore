package com.leticia.bookStore.service;

import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.dtos.CategoryDto;
import com.leticia.bookStore.exception.ObjectNotFoundException;
import com.leticia.bookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById (id);
        return obj.orElseThrow (() -> new ObjectNotFoundException (
                "Objeto não encontrado! id: " + id + ", Tipo:" + CategoryRepository.class.getName ()));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll ();
    }

    public Category create(Category obj) {
        return null;
    }

    public Category create(Integer id, CategoryDto objDto) {
        Category obj = findById (id);
        obj.setNome (obj.getNome ());
        obj.setDescricao (objDto.getDescricao ());
        return categoryRepository.save (obj);
    }

    public void delete(Integer id) {
        findById (id);
        try {
            categoryRepository.deleteById (id);
        } catch (DataIntegrityViolationException e) {
            throw new com.leticia.bookStore.exception.DataIntegrityViolationException
                    ("Objeto não pode ser deletado! Possui livros associados.");
        }
    }
}

