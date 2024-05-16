package com.leticia.bookStore.service;

import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.exception.ObjectNotFoundException;
import com.leticia.bookStore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
          "Objeto não encontrado! id: " + id + ", Tipo:" + CategoryRepository.class.getName()));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll ();
    }
}
