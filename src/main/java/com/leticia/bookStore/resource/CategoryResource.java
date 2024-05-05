package com.leticia.bookStore.resource;

import com.leticia.bookStore.domain.Category;
import com.leticia.bookStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Category")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;
    @GetMapping(value = "/{id}")
   public ResponseEntity<Category> findById(@PathVariable Integer id) {
      Category obj = categoryService.findById (id);
      return ResponseEntity.ok ().body (obj);
    }
}
